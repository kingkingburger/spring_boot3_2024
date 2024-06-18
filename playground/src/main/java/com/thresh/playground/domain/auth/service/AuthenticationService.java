package com.thresh.playground.domain.auth.service;

import com.thresh.playground.domain.auth.dto.AuthenticationRequest;
import com.thresh.playground.domain.auth.dto.RegisterRequest;
import com.thresh.playground.domain.user.entity.Role;
import com.thresh.playground.domain.user.entity.User;
import com.thresh.playground.domain.user.repository.UserRepository;
import com.thresh.playground.global.config.JwtService;
import com.thresh.playground.global.exception.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public String register(RegisterRequest request) {
    // var 타입은 뭐지? => java에서 쓰는 any 같은 용도
    var user =
        User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
    userRepository.save(user);

    var jwtToken = jwtService.generateToken(user);

    return jwtToken;
  }

  // 사용자의 인증을 해주는 메서드
  public String authentication(AuthenticationRequest request) {
    try {
      Authentication authenticate =
          authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
      log.info("로그인 AuthenticationService: " + authenticate.getPrincipal());

      if (authenticate.isAuthenticated()) {
        var user = (User) authenticate.getPrincipal();
        return jwtService.generateToken(user);
      }

    } catch (BadCredentialsException e) {
      // 잘못된 아이디 또는 비밀번호
      log.error("Login failed: ", e);
      return Constants.INVALID_USERNAME_OR_PASSWORD_MESSAGE;
    } catch (AuthenticationException e) {
      // 로그인 실패 처리
      log.error("Login failed: ", e);
      return Constants.LOGIN_ERROR_MESSAGE;
    }
    return null;
  }
}
