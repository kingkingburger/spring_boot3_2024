package com.thresh.playground.domain.user.entity;

import com.thresh.playground.domain.user.entity.constant.RoleType;
import com.thresh.playground.domain.user.entity.constant.UserStatus;
import com.thresh.playground.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS")
@Getter
@Entity
public class User extends BaseTimeEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id; // 유저pk

  //  @Column(name = "login_id", nullable = false)
  //  private String loginId;     // 로그인 ID

  @Column(name = "password", nullable = false)
  private String password; // 로그인 비밀번호

  @Column(name = "username", nullable = false)
  private String username; // 유저실명

  @Column(name = "email", nullable = false)
  private String email; // 이메일

  @Column(name = "roleType", nullable = false)
  @Enumerated(EnumType.STRING)
  private RoleType roleType; // 계정 타입

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserStatus userStatus;

  @Column(name = "role", nullable = false)
  private String role;

  // id, 생성일자, 수정일자는 자동으로 등록된다.
  @Builder
  private User(
      Long id,
      //      String loginId,
      String password,
      String username,
      String email,
      String role,
      RoleType roleType,
      UserStatus userStatus) {
    this.id = id;
    //    this.loginId = loginId;
    this.password = password;
    this.username = username;
    this.email = email;
    this.role = role;
    this.roleType = roleType;
    this.userStatus = userStatus;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    List<GrantedAuthority> roles = new ArrayList<>();
    roles.add(new SimpleGrantedAuthority(role));

    return roles;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
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
}
