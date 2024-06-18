package com.thresh.playground.domain.comment.service;

import com.thresh.playground.domain.comment.repository.CommentRepository;
import com.thresh.playground.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
}
