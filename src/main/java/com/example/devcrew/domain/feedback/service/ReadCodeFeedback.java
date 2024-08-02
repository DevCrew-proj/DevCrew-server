package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.ReadCodeFeedbackResponseDTO;

public interface ReadCodeFeedback {
    ReadCodeFeedbackResponseDTO readCodeFeedback(Long feedbackId);
}
