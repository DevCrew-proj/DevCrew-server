package com.example.devcrew.domain.comment.service;

import com.example.devcrew.domain.comment.entity.Comment;

import java.util.List;

public interface ReadComment {
    public List<Comment> getComments(Long feedbackId);
}
