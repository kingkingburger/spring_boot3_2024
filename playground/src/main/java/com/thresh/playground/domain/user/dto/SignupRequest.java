package com.thresh.playground.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupRequest {
  private final String email;
  private final String password;
}
