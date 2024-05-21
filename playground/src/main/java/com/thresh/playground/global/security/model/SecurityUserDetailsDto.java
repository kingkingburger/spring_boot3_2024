package com.thresh.playground.global.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thresh.playground.domain.user.dto.UserDto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.experimental.Delegate;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
public class SecurityUserDetailsDto implements UserDetails {
  private final Long userId;
  private final String email;

  @JsonIgnore private final String password;

  private final List<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true; // <-- Very important to not forget
  }

  @Override
  public boolean isAccountNonLocked() {
    return true; // <-- Very important to not forget
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true; // <-- Very important to not forget
  }

  @Override
  public boolean isEnabled() {
    return true; // <-- Very important to not forget
  }
}
