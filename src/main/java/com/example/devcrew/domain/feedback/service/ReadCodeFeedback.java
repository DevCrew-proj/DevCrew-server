package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackResponseDTO;

public interface ReadCodeFeedback {
    ReadCodeFeedbackResponseDTO readCodeFeedback(Long feedbackId);
}
