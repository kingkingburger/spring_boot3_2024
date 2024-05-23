package com.thresh.playground.global.security3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Getter
public enum TokenType {
  ACCESS("access"),
  REFRESH("refresh"),
  TEMPORARY("temporary");
  private final String typeKey;

  public static TokenType fromString(String typeKey) {
    return switch (typeKey.toUpperCase()) {
      case "ACCESS" -> ACCESS;
      case "REFRESH" -> REFRESH;
      case "TEMPORARY" -> TEMPORARY;
      default -> throw new InvalidParameterException();
    };
  }
}
