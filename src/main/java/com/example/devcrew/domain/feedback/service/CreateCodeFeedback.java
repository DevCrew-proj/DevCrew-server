package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;

public interface CreateCodeFeedback {
    Feedback createCodeFeedback(CreateCodeFeedbackRequestDTO request);
}