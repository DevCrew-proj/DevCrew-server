package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import org.springframework.security.core.userdetails.UserDetails;

public interface CreateAdviceFeedback {

    Feedback createAdviceFeedback(CreateAdviceFeedbackRequestDTO request);
}
