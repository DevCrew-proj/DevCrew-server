package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
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
public class ReadAdviceFeedbackImpl implements ReadAdviceFeedback {

    private final FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return AdviceFeedbackConverter.toReadAdviceFeedbackResponseDTO(feedback);
    }

    @Override
    @Transactional
    public ReadAdviceFeedbackListResponseDTO readAdviceFeedbackList(FeedbackTag feedbackTag, int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);  // 한 페이지에 4개의 게시글

        Page<Feedback> feedbackPage = feedbackRepository.findByAdviceFeedback_FeedbackTag(feedbackTag, pageRequest);

        List<ReadAdviceFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(AdviceFeedbackConverter::toReadAdviceFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadAdviceFeedbackListResponseDTO(feedbackList, feedbackPage.getTotalPages());
    }

}
