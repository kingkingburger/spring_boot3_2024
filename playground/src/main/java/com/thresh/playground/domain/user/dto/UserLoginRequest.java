package com.thresh.playground.domain.user.dto;

import com.thresh.playground.domain.user.entity.User;
import java.time.LocalDateTime;

/** DTO for {@link User} */
public record UserLoginRequest(
    String username,
    String password,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {

  // factory method of 선언
  public static UserLoginRequest of(
      String username,
      String password,
      String email,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    return new UserLoginRequest(username, password, email, createdAt, updatedAt);
  }

  // security에서 사용할 팩토리 메서드
  public static UserLoginRequest of() {
    return new UserLoginRequest(null, null, null, null, null);
  }

  // Principal에서 사용할 factory method of 선언
  public static UserLoginRequest of(String username, String password, String email) {
    return new UserLoginRequest(username, password, email, null, null);
  }

  // 서비스 레이어에서 entity를 dto로 변환시켜주는 코드
  public static UserLoginRequest fromEntity(User entity) {
    return UserLoginRequest.of(
        entity.getUsername(),
        entity.getPassword(),
        entity.getEmail(),
        entity.getCreatedDate(),
        entity.getUpdatedDate());
  }
}
