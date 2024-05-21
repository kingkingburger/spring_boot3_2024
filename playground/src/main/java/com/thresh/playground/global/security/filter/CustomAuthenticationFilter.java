package com.thresh.playground.global.security.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thresh.playground.domain.user.dto.UserDto;
import com.thresh.playground.global.exception.ErrorCode;
import com.thresh.playground.global.exception.ProfileApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * UsernamePasswordAuthenticationFilter를 상속받아 사용자 정의 인증 필터를 구현했다. 이 필터는 사용자가 로그인 폼을 통해 제출한 사용자 이름과
 * 비밀번호를 가지고 인증을 시도하며, 인증이 성공하면 인증된 사용자의 정보와 권한을 담은 Authentication 객체를 생성하여 SecurityContext에 저장한다.
 * 이렇게 SecurityContext에 저장된 사용자의 정보와 권한은 애플리케이션의 다른 부분에서 사용될 수 있다.
 *
 * <p>설명: 이 필터는 "/user/login" 엔드포인트로 들어오는 요청을 처리한다. 클라이언트에서 ajax로 "/user/login" 엔드포인트로 요청을 보낼 때 이
 * 필터에서 요청을 처리하고, 인증이 성공하면 CustomAuthSuccessHandler에서 응답을 반환한다.
 */
@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  /**
   * 이 메서드는 사용자가 로그인을 시도할 때 호출된다. HTTP 요청에서 사용자 이름과 비밀번호를 추출하여 UsernamePasswordAuthenticationToken
   * 객체를 생성하고, 이를 AuthenticationManager에 전달하여 인증을 시도한다. 인증이 성공하면 인증된 사용자의 정보와 권한을 담은 Authentication
   * 객체를 반환하고, 인증이 실패하면 AuthenticationException을 던진다.
   */
  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    log.info("JwtAutehnticationFilter 로그인: 진입");

    //    UsernamePasswordAuthenticationToken authRequest;
    //
    //    try {
    //      authRequest = getAuthRequest(request);
    //      setDetails(request, authRequest);
    //    } catch (Exception e) {
    //      throw new ProfileApplicationException(ErrorCode.BUSINESS_EXCEPTION_ERROR);
    //    }
    //
    //    // Authentication 객체를 반환한다.
    //    return this.getAuthenticationManager().authenticate(authRequest);
    log.info("JwtAuthenticationFilter 로그인 : 진입");
    // 로그인 요청 시 들어온 데이터를 객체로 변환
    ObjectMapper om = new ObjectMapper();
    UserDto userLoginRequest = null;
    try {
      userLoginRequest = om.readValue(request.getInputStream(), UserDto.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 해당 객체로 로그인 시도를 위한 유저네임패스워드 authenticationToken 생성
    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(
            userLoginRequest.username(), userLoginRequest.password());

    // authenticate() 함수가 호출 되면 인증 프로바이더가 유저 디테일 서비스의
    // loadUserByUsername(토큰의 첫번째 파라미터) 를 호출하고
    // UserDetails를 리턴받아서 토큰의 두번째 파라메터(credential)과
    // UserDetails(DB값)의 getPassword()함수로 비교해서 동일하면
    // Authentication 객체를 만들어서 필터체인으로 리턴해준다.
    Authentication authentication = authenticationManager.authenticate(authenticationToken);
    // Tip: 인증 프로바이더의 디폴트 서비스는 UserDetailsService 타입
    // Tip: 인증 프로바이더의 디폴트 암호화 방식은 BCryptPasswordEncoder
    // 결론은 인증 프로바이더에게 알려줄 필요가 없음.

    // 위 영역이 성공했다면, session영역에 authenticaion 객체가 저장된다->로그인이 성공
    return authentication;
  }

  /**
   * 이 메서드는 HTTP 요청에서 사용자 이름과 비밀번호를 추출하여 UsernamePasswordAuthenticationToken 객체를 생성하는 역할을 한다. HTTP
   * 요청의 입력 스트림에서 JSON 형태의 사용자 이름과 비밀번호를 읽어 UserDto 객체를 생성하고, 이를 기반으로
   * UsernamePasswordAuthenticationToken 객체를 생성한다.
   */
  private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request)
      throws Exception {

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());
      objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

      UserDto user = objectMapper.readValue(request.getInputStream(), UserDto.class);
      log.debug(
          "1.CustomAuthenticationFilter :: loginId: "
              + user.loginId()
              + "userPw: "
              + user.password());

      /**
       * ID, PW를 기반으로 UsernamePasswordAuthenticationToken 토큰을 발급한다.
       * UsernamePasswordAuthenticationToken 객체가 처음 생성될 때 authenticated 필드는 기본적으로 false로 설정된다.
       */
      return new UsernamePasswordAuthenticationToken(user.loginId(), user.password());
    } catch (UsernameNotFoundException e) {
      throw new UsernameNotFoundException(e.getMessage());
    } catch (Exception e) {
      throw new ProfileApplicationException(ErrorCode.IO_ERROR);
    }
  }
}
