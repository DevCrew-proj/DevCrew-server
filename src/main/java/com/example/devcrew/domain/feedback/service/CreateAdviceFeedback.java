package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import org.springframework.stereotype.Service;

@Service
public interface CreateAdviceFeedback {

    Feedback createAdviceFeedback(CreateAdviceFeedbackRequestDTO request);
}
