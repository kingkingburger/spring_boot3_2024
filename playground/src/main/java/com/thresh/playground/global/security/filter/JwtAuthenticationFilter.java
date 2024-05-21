package com.thresh.playground.global.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;

import com.thresh.playground.domain.user.dto.UserLoginRequest;
import com.thresh.playground.domain.user.entity.PrincipalDetails;
import com.thresh.playground.domain.user.entity.constant.JwtProperties;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/** 지정한 URL별 JWT의 유효성 검증을 수행하며 직접적인 사용자 인증을 확인합니다. */
// @Slf4j
// @RequiredArgsConstructor
// public class JwtAuthorizationFilter extends OncePerRequestFilter {
//
//  private final UserDetailsService userDetailsService;
//  private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new
// JavaTimeModule());
//
//  @Override
//  protected void doFilterInternal(
//      HttpServletRequest request,
//      @NonNull HttpServletResponse response,
//      @NonNull FilterChain filterChain)
//      throws ServletException, IOException {
//
//    // 1. 토큰이 필요하지 않은 API URL에 대해서 배열로 구성한다.
//    List<String> list =
//        Arrays.asList(
//            "/api/auth/signup", // 로그인 페이지의 URL을 추가합니다.
//            "/api/auth/login" // 로그인 페이지의 URL을 추가합니다.
//            );
//
//    // 2. 토큰이 필요하지 않은 API URL의 경우 -> 로직 처리없이 다음 필터로 이동한다.
//    if (list.contains(request.getRequestURI())) {
//      filterChain.doFilter(request, response);
//      return;
//    }
//
//    // 3. OPTIONS 요청일 경우 -> 로직 처리 없이 다음 필터로 이동
//    if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
//      filterChain.doFilter(request, response);
//      return;
//    }
//
//    // [STEP.1] Client에서 API를 요청할때 쿠키를 확인한다.
//    Cookie[] cookies = request.getCookies();
//    String token = null;
//    if (cookies != null) {
//      for (Cookie cookie : cookies) {
//        if ("jwt".equals(cookie.getName())) {
//          token = cookie.getValue();
//          break;
//        }
//      }
//    }
//
//    try {
//      // [STEP.2-1] 쿠키 내에 토큰이 존재하는 경우
//      if (token != null && !token.equalsIgnoreCase("")) {
//
//        // [STEP.2-2] 쿠키 내에있는 토큰이 유효한지 여부를 체크한다.
//        if (TokenUtils.isValidToken(token)) {
//
//          // [STEP.2-3] 추출한 토큰을 기반으로 사용자 아이디를 반환받는다.
//          String loginId = TokenUtils.getUserIdFromToken(token);
//          log.debug("[+] loginId Check: " + loginId);
//
//          // [STEP.2-4] 사용자 아이디가 존재하는지에 대한 여부를 체크한다.
//          if (loginId != null && !loginId.equalsIgnoreCase("")) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
//            UsernamePasswordAuthenticationToken authentication =
//                new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            filterChain.doFilter(request, response);
//          } else {
//            throw new ProfileApplicationException(ErrorCode.USER_NOT_FOUND);
//          }
//        }
//        // [STEP.2-5] 토큰이 유효하지 않은 경우
//        else {
//          throw new ProfileApplicationException(ErrorCode.TOKEN_NOT_VALID);
//        }
//      }
//      // [STEP.3] 토큰이 존재하지 않는 경우
//      else {
//        throw new ProfileApplicationException(ErrorCode.TOKEN_NOT_FOUND);
//      }
//    } catch (Exception e) {
//      // 로그 메시지 생성
//      log.error(e.getMessage(), e);
//
//      // 클라이언트에게 전송할 고정된 메시지
//      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//      response.setCharacterEncoding("UTF-8");
//      response.setContentType("application/json");
//
//      Map<String, Object> errorResponse = new HashMap<>();
//      errorResponse.put("error", true);
//      errorResponse.put("message", "로그인 에러");
//      errorResponse.put("details", jsonResponseWrapper(e));
//
//      PrintWriter printWriter = response.getWriter();
//      String jsonResponse = objectMapper.writeValueAsString(errorResponse);
//      printWriter.print(jsonResponse);
//      printWriter.flush();
//      printWriter.close();
//    }
//  }
//
//  /** 토큰 관련 Exception 발생 시 예외 응답값 구성 */
//  private Map<String, Object> jsonResponseWrapper(Exception e) {
//
//    String resultMessage = "";
//    // JWT 토큰 만료
//    if (e instanceof ExpiredJwtException) {
//      resultMessage = "TOKEN Expired";
//    }
//    // JWT 허용된 토큰이 아님
//    else if (e instanceof SignatureException) {
//      resultMessage = "TOKEN SignatureException Login";
//    }
//    // JWT 토큰내에서 오류 발생 시
//    else if (e instanceof JwtException) {
//      resultMessage = "TOKEN Parsing JwtException";
//    }
//    // 이외 JTW 토큰내에서 오류 발생
//    else {
//      resultMessage = "OTHER TOKEN ERROR";
//    }
//
//    Map<String, Object> jsonMap = new HashMap<>();
//    jsonMap.put("status", 401);
//    jsonMap.put("code", "9999");
//    jsonMap.put("message", resultMessage);
//    jsonMap.put("reason", e.getMessage());
//    log.error(resultMessage, e);
//    return jsonMap;
//  }
// }

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  @Override
  // Authentication 객체 만들어서 리턴해야 한다.(AuthenticationManager를 통해서)
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    log.info("JwtAuthenticationFilter 로그인 : 진입");
    // 로그인 요청 시 들어온 데이터를 객체로 변환
    ObjectMapper om = new ObjectMapper();
    UserLoginRequest userLoginRequest = null;
    try {
      userLoginRequest = om.readValue(request.getInputStream(), UserLoginRequest.class);
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

  @Override
  // 로그인 인증 성공하면 들어오는 메소드
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws IOException, ServletException {
    // Authentication에 있는 정보로 JWT Token 생성해서 response에 담아주기
    PrincipalDetails principalDetailis = (PrincipalDetails) authResult.getPrincipal();
    String jwtToken =
        JWT.create()
            .withSubject(principalDetailis.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
            .withClaim("id", principalDetailis.getUser().getId())
            .withClaim("username", principalDetailis.getUser().getUsername())
            .sign(Algorithm.HMAC512(JwtProperties.SECRET));

    response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);
  }
}
