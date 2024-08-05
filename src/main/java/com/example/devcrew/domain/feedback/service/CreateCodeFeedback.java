package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import org.springframework.stereotype.Service;

@Service
public interface CreateCodeFeedback {
    Feedback createCodeFeedback(CreateCodeFeedbackRequestDTO request);
}
