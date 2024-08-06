package com.example.devcrew.domain.comment.service;

import com.example.devcrew.domain.comment.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadComment {
    public List<Comment> getComments(Long feedbackId);
}
