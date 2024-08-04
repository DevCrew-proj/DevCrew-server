package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;

public interface ReadAdviceFeedback {
    ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId);

    ReadAdviceFeedbackListResponseDTO readAdviceFeedbackList(FeedbackTag feedbackTag, int page);
}
