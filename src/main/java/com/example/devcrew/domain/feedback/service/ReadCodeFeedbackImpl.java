package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadCodeFeedbackImpl implements ReadCodeFeedback {
    private final FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public ReadCodeFeedbackResponseDTO readCodeFeedback(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return CodeFeedbackConverter.toReadCodeFeedbackResponseDTO(feedback);
    }
}
