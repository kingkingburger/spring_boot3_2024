package com.thresh.playground.global.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thresh.playground.domain.user.dto.UserDto;
import com.thresh.playground.global.security.jwt.TokenUtils;
import com.thresh.playground.global.security.model.SecurityUserDetailsDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

  /**
   * 이 메서드는 HTTP 요청, HTTP 응답, 그리고 인증 객체를 인자로 받는다. 인증 객체에서 사용자 정보를 가져와 JSON 형태로 변환하고, 이를 클라이언트에 응답한다.
   * 코드를 살펴보면, 사용자의 상태에 따라 응답을 다르게 구성하고 있다. 사용자의 상태가 '휴먼 상태'인 경우와 그렇지 않은 경우에 대해 각각 다른 응답을 구성하고 있다.
   */
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {

    log.debug("3.CustomLoginSuccessHandler");

    // 1. 사용자와 관련된 정보를 모두 조회한다.
    UserDto userDto = ((SecurityUserDetailsDto) authentication.getPrincipal()).getUserDto();

    // 2. 응답값을 구성할 맵을 생성한다.
    Map<String, Object> responseMap = new HashMap<>();

    // 3-1. 사용자의 상태가 '휴먼 상태'인 경우에 응답값으로 전달할 데이터
    if (Objects.equals(userDto.status(), "D")) {
      responseMap.put("userInfo", userDto);
      responseMap.put("resultCode", 9001);
      responseMap.put("token", null);
      responseMap.put("failMessage", "휴면 계정입니다.");
    }
    // 3-2. 사용자의 상태가 '휴먼 상태'가 아닌 경우에 응답값으로 전달할 데이터
    else {
      // 1. 일반 계정일 경우 데이터 세팅
      responseMap.put("userInfo", userDto);
      responseMap.put("resultCode", 200);
      responseMap.put("failMessage", null);

      // JWT 토큰 생성
      String token = TokenUtils.generateJwtToken(userDto);
      responseMap.put("token", token);

      // 쿠키에 JWT 토큰 저장
      Cookie jwtCookie = new Cookie("jwt", token);
      jwtCookie.setHttpOnly(true); // JavaScript에서 쿠키에 접근할 수 없도록 설정
      jwtCookie.setPath("/"); // 모든 경로에서 쿠키에 접근 가능하도록 설정
      response.addCookie(jwtCookie); // 응답에 쿠키 추가
    }

    // 4. 구성한 응답값을 전달한다.
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");

    try (PrintWriter printWriter = response.getWriter()) {
      String jsonResponse = objectMapper.writeValueAsString(responseMap);
      printWriter.print(jsonResponse); // 최종 저장된 '사용자 정보', '사이트 정보'를 Front에 전달
      printWriter.flush();
    }
  }
}
