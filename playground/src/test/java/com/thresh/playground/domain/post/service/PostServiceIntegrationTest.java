package com.thresh.playground.domain.post.service;

import com.thresh.playground.domain.comment.entity.Comment;
import com.thresh.playground.domain.comment.repository.CommentRepository;
import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.domain.post.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PostServiceIntegrationTest {

  @Autowired private PostService postService;

  @Autowired private PostRepository postRepository;

  @Autowired private CommentRepository commentRepository;

  private Post post;
  private UUID postId;

  @BeforeEach
  void setUp() {
    postId = UUID.randomUUID();
    post = new Post();
    post.setId(postId);
    post.setTitle("Sample Post");

    postRepository.save(post);

    for (int i = 0; i < 5; i++) {
      Comment comment = new Comment();
      comment.setContent("Sample Comment " + i);
      comment.setPost(post);
      commentRepository.save(comment);
    }
  }

  @Test
  @Transactional
  void testGetPostWithComments() {
    Post result = postService.getPostById(postId);

    assertNotNull(result);
    List<Comment> comments = result.getComments();
    assertEquals(5, comments.size());

    for (int i = 0; i < comments.size(); i++) {
      assertEquals("Sample Comment " + i, comments.get(i).getContent());
    }
  }
}
