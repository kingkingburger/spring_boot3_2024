package com.thresh.playground.global.security2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider2 implements AuthenticationProvider {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String loginId = authentication.getName();
    String password = (String) authentication.getCredentials();

    User2 entity = (User2) userDetailsService.loadUserByUsername(loginId);

    if (!passwordEncoder.matches(password, entity.getPassword())) {
      throw new BadCredentialsException("Invalid Password");
    }

    return new CustomAuthenticationToken(entity, null, entity.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(CustomAuthenticationToken.class);
  }
}
