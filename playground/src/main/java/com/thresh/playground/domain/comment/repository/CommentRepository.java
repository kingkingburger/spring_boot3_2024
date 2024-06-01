package com.thresh.playground.domain.comment.repository;

import com.thresh.playground.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
