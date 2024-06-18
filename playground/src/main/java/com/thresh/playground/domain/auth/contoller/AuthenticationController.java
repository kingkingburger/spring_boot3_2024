package com.thresh.playground.domain.auth.contoller;

import com.thresh.playground.domain.auth.dto.AuthenticationRequest;
import com.thresh.playground.domain.auth.dto.AuthenticationResponse;
import com.thresh.playground.domain.auth.dto.RegisterRequest;
import com.thresh.playground.domain.auth.service.AuthenticationService;
import com.thresh.playground.domain.user.repository.UserRepository;
import com.thresh.playground.global.exception.ErrorCode;
import com.thresh.playground.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;
  private final UserRepository userRepository;

  @PostMapping("/register")
  public ApiResponse register(@RequestBody RegisterRequest request) {
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      return ApiResponse.failure(ErrorCode.USER_ALREADY_EXIST);
    }

    String token = authenticationService.register(request);

    return ApiResponse.ok(token);
  }

  // token refresh 용도
  @PostMapping("/authentication")
  public ApiResponse authentication(@RequestBody AuthenticationRequest request) {
    AuthenticationResponse authentication = authenticationService.authentication(request);

    if (authentication == null || authentication.getToken() == null) {
      return ApiResponse.failure(ErrorCode.USER_NOT_FOUND);
    }

    return ApiResponse.ok(authentication.getToken());
  }
}
