package com.thresh.playground.domain.post.service;

import com.thresh.playground.domain.comment.entity.Comment;
import com.thresh.playground.domain.comment.repository.CommentRepository;
import com.thresh.playground.domain.post.entity.Post;
import com.thresh.playground.domain.post.exception.PostNotFoundException;
import com.thresh.playground.domain.post.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

  @Mock private PostRepository postRepository;

  @Mock private CommentRepository commentRepository;

  @InjectMocks private PostService postService;

  private Post post;
  private UUID postId;
  private List<Comment> comments;

  @BeforeEach
  void setUp() {
    postId = UUID.randomUUID();
    post = new Post();
    post.setId(postId);
    post.setTitle("Sample Post");

    comments = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Comment comment = new Comment();
      comment.setId(Long.valueOf(i));
      comment.setContent("Sample Comment " + i);
      comment.setPost(post);
      comments.add(comment);
    }

    post.setComments(comments);
  }

  @Test
  @DisplayName("post객체 넣다 빼기")
  void testGetAllPost() {
    List<Post> posts = new ArrayList<>();
    posts.add(post);
    when(postRepository.findAll()).thenReturn(posts);

    List<Post> result = postService.getAllPost();

    assertEquals(1, result.size());
    verify(postRepository, times(1)).findAll();
  }

  @Test
  void testSavePost() {
    when(postRepository.save(post)).thenReturn(post);

    Post result = postService.savePost(post);

    assertNotNull(result);
    assertEquals(postId, result.getId());
    verify(postRepository, times(1)).save(post);
  }

  @Test
  void testGetPostById_Success() {
    when(postRepository.findById(postId)).thenReturn(Optional.of(post));

    Post result = postService.getPostById(postId);

    assertNotNull(result);
    assertEquals(postId, result.getId());
    verify(postRepository, times(1)).findById(postId);
  }

  @Test
  void testGetPostById_NotFound() {
    when(postRepository.findById(postId)).thenReturn(Optional.empty());

    assertThrows(PostNotFoundException.class, () -> postService.getPostById(postId));
    verify(postRepository, times(1)).findById(postId);
  }
}
