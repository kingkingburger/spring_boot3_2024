package com.thresh.playground.global.security.model;

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

@Slf4j
@Getter
@AllArgsConstructor
public class SecurityUserDetailsDto implements UserDetails {

  @Delegate private UserDto userDto;
  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(userDto.roleType().toString()));
  }

  @Override
  public String getPassword() {
    return userDto.password();
  }

  @Override
  public String getUsername() {
    return userDto.username();
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
