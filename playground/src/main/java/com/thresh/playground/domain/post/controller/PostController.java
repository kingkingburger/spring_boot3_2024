package com.thresh.playground.domain.post.controller;

import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.domain.post.service.PostService;
import java.util.List;
import java.util.UUID;

import com.thresh.playground.global.exception.ErrorCode;
import com.thresh.playground.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  @PostMapping
  public ApiResponse createPost(@RequestBody Post post) {
    return ApiResponse.ok(postService.savePost(post));
  }

  @GetMapping
  public ApiResponse<List<Post>> getPosts() {
    return ApiResponse.ok(postService.getAllPost());
  }

  @GetMapping("/id/{id}")
  public ApiResponse getPostById(@PathVariable UUID id) {
    try {
      return ApiResponse.ok(postService.getPostById(id));
    } catch (Exception e) {
      return ApiResponse.failure(ErrorCode.BAD_REQUEST_ERROR, e.getMessage());
    }
  }
}
