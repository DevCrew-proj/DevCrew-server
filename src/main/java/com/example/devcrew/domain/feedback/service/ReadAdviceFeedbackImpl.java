package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackRepository;
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
public class ReadAdviceFeedbackImpl {

    private final AdviceFeedbackRepository adviceFeedbackRepository;

    @Transactional
    public ReadAdviceFeedbackResponseDTO readAdviceFeedback(Long feedbackId) {
        AdviceFeedback adviceFeedback = adviceFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return AdviceFeedbackConverter.toReadAdviceFeedbackResponseDTO(adviceFeedback);
    }

    @Transactional
    public ReadAdviceFeedbackListResponseDTO readAdviceFeedbackList(FeedbackTag feedbackTag, int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);  // 한 페이지에 4개의 게시글

        Page<AdviceFeedback> feedbackPage = adviceFeedbackRepository.findByAdviceFeedback_FeedbackTag(feedbackTag, pageRequest);

        List<ReadAdviceFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(AdviceFeedbackConverter::toReadAdviceFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadAdviceFeedbackListResponseDTO(feedbackList, feedbackPage.getTotalPages());
    }

}
