package com.thresh.playground.global.service;

import com.thresh.playground.domain.user.entity.User;
import com.thresh.playground.domain.user.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByEmail(email);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User not found with email: " + email);
    }
    return new org.springframework.security.core.userdetails.User(
        user.get().getEmail(), user.get().getPassword(), user.get().getAuthorities());
  }
}
