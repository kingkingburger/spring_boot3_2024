package com.thresh.playground.domain.comment.service;

import com.thresh.playground.domain.comment.entity.Comment;
import com.thresh.playground.domain.comment.repository.CommentRepository;
import com.thresh.playground.domain.post.exception.PostNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final CommentRepository CommentRepository;

  public List<Comment> getAllComment() {
    return CommentRepository.findAll();
  }

  public Comment saveComment(Comment Comment) {
    return CommentRepository.save(Comment);
  }

  public Comment getCommentById(Long id) {
    return CommentRepository.findById(id)
        .orElseThrow(() -> new PostNotFoundException("Comment not found with id " + id));
  }
}
