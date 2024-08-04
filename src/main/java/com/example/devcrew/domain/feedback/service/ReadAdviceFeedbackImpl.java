package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadAdviceFeedbackImpl implements ReadAdviceFeedback {

    private final FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return AdviceFeedbackConverter.toReadAdviceFeedbackResponseDTO(feedback);
    }

}
