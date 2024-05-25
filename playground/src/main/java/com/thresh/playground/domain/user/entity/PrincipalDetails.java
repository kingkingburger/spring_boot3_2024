package com.thresh.playground.domain.user.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

  private User2 user2;

  public PrincipalDetails(User2 user2) {
    this.user2 = user2;
  }

  public User2 getUser() {
    return user2;
  }

  @Override
  public String getPassword() {
    return user2.getPassword();
  }

  @Override
  public String getUsername() {
    return user2.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    //      authorities.add(user.getRoleType())

    return authorities;
  }
}
