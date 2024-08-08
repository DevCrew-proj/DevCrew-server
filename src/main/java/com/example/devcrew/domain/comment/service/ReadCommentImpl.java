package com.example.devcrew.domain.comment.service;

import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.comment.repository.CodeCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadCommentImpl implements ReadComment{
    private final CodeCommentRepository commentRepository;

    @Override
    @Transactional
    public List<Comment> getComments(Long feedbackId) {
        return commentRepository.findByFeedbackId(feedbackId);
    }


}
