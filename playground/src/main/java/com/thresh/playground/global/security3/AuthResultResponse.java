package com.thresh.playground.global.security3;

public record AuthResultResponse(
    String accessToken, String refreshToken, boolean isTemporaryToken) {
  public static AuthResultResponse of(TokenPair tokenPair, boolean isTemporaryToken) {
    return new AuthResultResponse(
        tokenPair.accessToken(), tokenPair.refreshToken(), isTemporaryToken);
  }
}
