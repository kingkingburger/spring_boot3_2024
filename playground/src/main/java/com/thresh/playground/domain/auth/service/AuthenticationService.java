package com.thresh.playground.domain.auth.service;

import com.thresh.playground.domain.auth.dto.AuthenticationRequest;
import com.thresh.playground.domain.auth.dto.AuthenticationResponse;
import com.thresh.playground.domain.auth.dto.RegisterRequest;
import com.thresh.playground.domain.user.entity.Role;
import com.thresh.playground.domain.user.entity.User;
import com.thresh.playground.domain.user.repository.UserRepository;
import com.thresh.playground.global.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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

    //    return AuthenticationResponse.builder().token(jwtToken).build();
    return jwtToken;
  }

  // 사용자의 인증을 해주는 메서드
  public AuthenticationResponse authentication(AuthenticationRequest request) {
    Authentication authenticate =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    if (authenticate.isAuthenticated()) {
      var user = (User) authenticate.getPrincipal();
      var jwtToken = jwtService.generateToken(user);
      return AuthenticationResponse.builder().token(jwtToken).build();
    }
    return null;
  }
}
