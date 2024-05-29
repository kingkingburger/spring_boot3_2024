package com.thresh.playground.global.response;

import com.thresh.playground.global.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ApiResponse<T> {

  private final String message;
  private final int code;
  private final T data;

  public static <T> ApiResponse<T> ok() {
    return new ApiResponse<>("success", 200, null);
  }

  public static <T> ApiResponse<T> ok(T data) {
    return new ApiResponse<>("success", 200, data);
  }

  public static <T> ApiResponse<T> ok(ApiResponseMessage message) {
    return new ApiResponse<>(message.getMessage(), 200, null);
  }

  public static <T> ApiResponse<T> ok(ApiResponseMessage message, T data) {
    return new ApiResponse<>(message.getMessage(), 200, data);
  }

  public static <T> ApiResponse<T> create() {
    return new ApiResponse<>("create", 200, null);
  }

  public static <T> ApiResponse<T> create(T data) {
    return new ApiResponse<>("create", 200, data);
  }

  public static <T> ApiResponse<T> failure(ErrorCode ec) {
    return new ApiResponse<>(ec.getMessage(), ec.getStatus(), null);
  }

  public static <T> ApiResponse<T> failure(ErrorCode ec, T data) {
    return new ApiResponse<>(ec.getMessage(), ec.getStatus(), data);
  }
}
