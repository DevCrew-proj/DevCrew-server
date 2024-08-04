package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;

public interface CreateAdviceFeedback {

    Feedback createAdviceFeedback(CreateAdviceFeedbackRequestDTO request);
}
