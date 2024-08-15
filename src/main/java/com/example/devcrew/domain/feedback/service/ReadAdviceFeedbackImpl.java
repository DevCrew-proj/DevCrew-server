package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.comment.repository.AdviceCommentRepository;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadAdviceFeedbackImpl {

    private final AdviceFeedbackRepository adviceFeedbackRepository;
    private final AdviceCommentRepository adviceCommentRepository;

    @Transactional
    public ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId) {
        AdviceFeedback adviceFeedback = adviceFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        long commentCount = adviceCommentRepository.countByAdviceFeedback_Id(feedbackId);

        return AdviceFeedbackConverter.toReadAdviceFeedbackResponseDTO(adviceFeedback, commentCount);
    }

    @Transactional
    public ReadAdviceFeedbackListResponseDTO readAdviceFeedbackList(FeedbackTag feedbackTag, int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);

        Page<AdviceFeedback> feedbackPage = adviceFeedbackRepository.findByFeedbackTag(feedbackTag, pageRequest);

        return AdviceFeedbackConverter.toReadAdviceFeedbackListResponseDTO(feedbackPage, adviceCommentRepository);
    }

    @Transactional
    public ReadAdviceFeedbackListResponseDTO readAllAdviceFeedbackList(int page) {
        Pageable pageable = PageRequest.of(page, 4);

        Page<AdviceFeedback> feedbackPage = adviceFeedbackRepository.findAll(pageable);

        return AdviceFeedbackConverter.toReadAdviceFeedbackListResponseDTO(feedbackPage, adviceCommentRepository);
    }

}
