package com.thresh.playground.domain.post.controller;

import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.domain.post.service.PostService;
import java.util.List;
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
}
