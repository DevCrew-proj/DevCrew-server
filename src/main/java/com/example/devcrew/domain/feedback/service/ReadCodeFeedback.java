package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.feedback.entity.Language;
import org.springframework.stereotype.Service;

@Service
public interface ReadCodeFeedback {
    ReadCodeFeedbackResponseDTO readCodeFeedback(Long feedbackId);

    ReadCodeFeedbackListResponseDTO readCodeFeedbackList(Language language, int page);
}
