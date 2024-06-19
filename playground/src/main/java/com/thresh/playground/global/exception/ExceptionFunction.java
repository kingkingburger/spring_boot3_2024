package com.thresh.playground.global.exception;

import com.thresh.playground.global.response.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/** 여러가지 exception들을 api Response로 내보내기 위한 util */
@Component
@RequiredArgsConstructor
public class ExceptionFunction {

  public void apiException(ErrorCode errorCode, String data, HttpServletResponse response)
      throws IOException {
    ApiResponse<String> apiResponse = ApiResponse.failure(errorCode, data);
    String jsonResponse =
        String.format(
            "{\"message\":\"%s\",\"code\":\"%s\",\"data\":\"%s\"}",
            errorCode.getMessage(), errorCode.getCode(), data);

    response.setContentType("application/json;charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getWriter().write(jsonResponse);
  }
}
