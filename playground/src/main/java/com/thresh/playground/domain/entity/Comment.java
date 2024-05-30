package com.thresh.playground.domain.entity;

import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "parrent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> replies;

}
