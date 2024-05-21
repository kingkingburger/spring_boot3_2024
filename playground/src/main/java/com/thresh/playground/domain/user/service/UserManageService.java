package com.thresh.playground.domain.user.service;

import com.thresh.playground.domain.user.dto.UserSignupRequest;
import com.thresh.playground.domain.user.entity.User;
import com.thresh.playground.domain.user.repository.UserRepository;
import com.thresh.playground.global.exception.ErrorCode;
import com.thresh.playground.global.exception.ProfileApplicationException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserManageService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public void signup(UserSignupRequest request) {
    if (userRepository.findByUsername(request.username()).isPresent()) {
      throw new ProfileApplicationException(ErrorCode.DUPLICATED_USER_NAME);
    }
    User users =
        User.builder()
            .username(request.username())
            .password(passwordEncoder.encode(request.password()))
            .email(request.email())
            .build();
    userRepository.save(users);
  }
}
