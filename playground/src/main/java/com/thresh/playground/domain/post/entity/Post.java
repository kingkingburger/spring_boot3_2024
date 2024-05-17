package com.thresh.playground.domain.post.entity;

import com.thresh.playground.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Post extends BaseTimeEntity {
  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  @Lob
  private String content;

  @PrePersist
  public void prePersist() {
    if (this.id == null) {
      this.id = UUID.randomUUID();
    }
  }
}
