package com.thresh.playground.global.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thresh.playground.global.response.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  private final ObjectMapper objectMapper;

  @ExceptionHandler(Exception.class)
  public void handleAllExceptions(Exception ex, HttpServletResponse response) throws IOException {
    System.out.println("in");
    ErrorCode errorCode = ErrorCode.BAD_REQUEST_ERROR; // 기본 오류 코드
    String errorMessage = ex.getMessage(); // 예외 메시지

    ApiResponse<String> apiResponse = ApiResponse.failure(errorCode, errorMessage);

    response.setContentType("application/json;charset=UTF-8");
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
  }
}
