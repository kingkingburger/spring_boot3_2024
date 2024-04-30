package com.thresh.playground.domain.post.entity;

import com.thresh.playground.global.entity.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class Post extends BaseTimeEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  @Lob
  private String content;

  @Column private Long numOfLove = 0L;
}
