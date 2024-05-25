package com.thresh.playground.domain.user.dto;

import java.time.LocalDateTime;

/** DTO for {@link User2} */
public record UserSignupRequest(
    String username,
    String password,
    String email,
    String role,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {

  // factory method of 선언
  public static UserSignupRequest of(
      String username,
      String password,
      String email,
      String role,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    return new UserSignupRequest(username, password, email, role, createdAt, updatedAt);
  }

  // 서비스 레이어에서 entity를 dto로 변환시켜주는 코드
  public static UserSignupRequest fromEntity(User2 entity) {
    return UserSignupRequest.of(
        entity.getUsername(),
        entity.getPassword(),
        entity.getEmail(),
        entity.getRole(),
        entity.getCreatedDate(),
        entity.getUpdatedDate());
  }
}
