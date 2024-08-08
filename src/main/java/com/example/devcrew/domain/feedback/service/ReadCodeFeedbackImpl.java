package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.feedback.entity.Language;
import com.example.devcrew.domain.feedback.repository.CodeFeedbackRepository;
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
public class ReadCodeFeedbackImpl {
    private final CodeFeedbackRepository codeFeedbackRepository;

    @Transactional
    public ReadCodeFeedbackResponseDTO readCodeFeedback(Long feedbackId) {
        CodeFeedback codeFeedback = codeFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return CodeFeedbackConverter.toReadCodeFeedbackResponseDTO(codeFeedback);
    }

    @Transactional
    public ReadCodeFeedbackListResponseDTO readCodeFeedbackList(Language language, int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);  // 한 페이지에 4개의 게시글

        Page<CodeFeedback> feedbackPage = codeFeedbackRepository.findByCodeFeedback_Language(language, pageRequest);

        List<ReadCodeFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(CodeFeedbackConverter::toReadCodeFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadCodeFeedbackListResponseDTO(feedbackList, feedbackPage.getTotalPages());
    }
}
