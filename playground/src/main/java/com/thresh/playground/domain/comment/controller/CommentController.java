package com.thresh.playground.domain.comment.controller;

import com.thresh.playground.domain.comment.entity.Comment;
import com.thresh.playground.domain.comment.service.CommentService;
import com.thresh.playground.global.response.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping
  public ApiResponse createComment(@RequestBody Comment comment) {
    return ApiResponse.ok(commentService.saveComment(comment));
  }

  @GetMapping
  public ApiResponse<List<Comment>> getComments() {
    return ApiResponse.ok(commentService.getAllComment());
  }

  @GetMapping("/id/{id}")
  public ApiResponse getCommentById(@PathVariable Long id) {
    return ApiResponse.ok(commentService.getCommentById(id));
  }
}
