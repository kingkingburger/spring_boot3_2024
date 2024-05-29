package com.thresh.playground.domain.post.controller;

import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.domain.post.service.PostService;
import java.util.List;
import java.util.UUID;

import com.thresh.playground.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return postService.savePost(post);
  }

  @GetMapping
  public List<Post> getPosts() {
    return postService.getAllPost();
  }

  @GetMapping("/id/{id}")
  public ApiResponse getPostById(@PathVariable UUID id) {
    return ApiResponse.ok(postService.getPostById(id));
  }
}
