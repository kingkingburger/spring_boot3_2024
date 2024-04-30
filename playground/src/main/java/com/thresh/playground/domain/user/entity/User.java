package com.thresh.playground.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRoleEnum role;

  //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  //  private List<LovePost> lovePostList;

  //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  //  private List<LoveComment> loveCommentList;

  //  public User(String userId, String password, UserRoleEnum role) {
  //    this.userId = userId;
  //    this.password = password;
  //    this.role = role;
  //  }
}
