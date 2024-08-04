package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.feedback.entity.Language;
import com.example.devcrew.domain.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    @Transactional
    public ReadCodeFeedbackListResponseDTO readCodeFeedbackList(Language language, int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);  // 한 페이지에 4개의 게시글

        Page<Feedback> feedbackPage = feedbackRepository.findByCodeFeedback_Language(language, pageRequest);

        List<ReadCodeFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(CodeFeedbackConverter::toReadCodeFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadCodeFeedbackListResponseDTO(feedbackList, feedbackPage.getTotalPages());
    }
}
