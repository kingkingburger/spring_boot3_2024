// package com.thresh.playground.domain.user.service;
//
// import com.thresh.playground.domain.user.dto.UserSignupRequest;
// import com.thresh.playground.domain.user.entity.constant.RoleType;
// import com.thresh.playground.domain.user.entity.constant.UserStatus;
// import com.thresh.playground.domain.user.repository.UserRepository;
// import com.thresh.playground.global.exception.ErrorCode;
// import com.thresh.playground.global.exception.ProfileApplicationException;
// import jakarta.transaction.Transactional;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
//
// import java.util.Optional;
//
// @Service
// @RequiredArgsConstructor
// @Slf4j
// public class UserManageService implements UserDetailsService {
//
//  private final UserRepository userRepository;
//
//  private final PasswordEncoder passwordEncoder;
//
//  @Transactional
//  public User2 signup(UserSignupRequest request) {
//    if (userRepository.findByUsername(request.username()).isPresent()) {
//      throw new ProfileApplicationException(ErrorCode.DUPLICATED_USER_NAME);
//    }
//    User2 users =
//        User2.builder()
//            .username(request.username())
//            .password(passwordEncoder.encode(request.password()))
//            .email(request.email())
//            .roleType(RoleType.USER)
//            .role(request.role())
//            .userStatus(UserStatus.D)
//            .build();
//    userRepository.save(users);
//    return users;
//  }
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    User2 entity =
//        userRepository
//            .findByUsername(username)
//            .orElseThrow(() -> new ProfileApplicationException(ErrorCode.USER_NOT_FOUND));
//    return entity;
//  }
//
//  public Optional<User2> findByUsername(String username) {
//    return userRepository.findByUsername(username);
//  }
// }
