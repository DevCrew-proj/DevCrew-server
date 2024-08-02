package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.ReadAdviceFeedbackResponseDTO;

public interface ReadAdviceFeedback {
    ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId);
}
