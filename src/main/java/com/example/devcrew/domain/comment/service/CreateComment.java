package com.example.devcrew.domain.comment.service;

import com.example.devcrew.domain.comment.dto.request.PostCommentRequestDTO;
import com.example.devcrew.domain.comment.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CreateComment {

    Comment createComment(Long feedbackId, Long memberId, PostCommentRequestDTO request);
}
