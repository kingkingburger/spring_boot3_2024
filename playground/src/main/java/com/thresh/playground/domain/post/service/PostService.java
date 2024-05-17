package com.thresh.playground.domain.post.service;

import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.domain.post.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  public Post savePost(Post post) {
    return postRepository.save(post);
  }
}
