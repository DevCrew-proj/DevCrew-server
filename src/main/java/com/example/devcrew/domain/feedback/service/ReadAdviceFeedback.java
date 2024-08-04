package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackResponseDTO;

public interface ReadAdviceFeedback {
    ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId);
}
