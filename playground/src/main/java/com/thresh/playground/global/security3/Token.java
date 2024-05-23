package com.thresh.playground.global.security3;

public record Token(String userId, TokenType tokenType, String provider) {}
