package com.thresh.playground.domain.post.entity;

import com.thresh.playground.domain.comment.entity.Comment;
import com.thresh.playground.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;
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

  @BatchSize(size = 10)
  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comment> comments = new ArrayList<>();
}
