package com.thresh.playground.domain.user.dto;

import com.thresh.playground.domain.user.entity.User;
import com.thresh.playground.domain.user.entity.constant.RoleType;
import com.thresh.playground.domain.user.entity.constant.UserStatus;
import java.time.LocalDateTime;

/** DTO for {@link User} */
public record UserSignupRequest(
    String username,
    String password,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {

  // factory method of 선언
  public static UserSignupRequest of(
      String username,
      String password,
      String email,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    return new UserSignupRequest(username, password, email, createdAt, updatedAt);
  }

  // security에서 사용할 팩토리 메서드
  public static UserSignupRequest of() {
    return new UserSignupRequest(null, null, null, null, null);
  }

  // Principal에서 사용할 factory method of 선언
  public static UserSignupRequest of(String username, String password, String email) {
    return new UserSignupRequest(username, password, email, null, null);
  }

  // 서비스 레이어에서 entity를 dto로 변환시켜주는 코드
  public static UserSignupRequest fromEntity(User entity) {
    return UserSignupRequest.of(
        entity.getUsername(),
        entity.getPassword(),
        entity.getEmail(),
        entity.getCreatedDate(),
        entity.getUpdatedDate());
  }
}
