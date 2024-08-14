package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.comment.repository.CodeCommentRepository;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackResponseDTO;
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
    private final CodeCommentRepository codeCommentRepository;

    @Transactional
    public ReadCodeFeedbackResponseDTO readCodeFeedback(Long feedbackId) {
        CodeFeedback codeFeedback = codeFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        long commentCount = codeCommentRepository.countByCodeFeedback_Id(feedbackId);

        ReadCodeFeedbackResponseDTO responseDTO = CodeFeedbackConverter.toReadCodeFeedbackResponseDTO(codeFeedback);
        responseDTO.setCommnetCount(commentCount);

        return responseDTO;
    }

    @Transactional
    public ReadCodeFeedbackListResponseDTO readCodeFeedbackList(Language language, int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);  // 한 페이지에 4개의 게시글

        Page<CodeFeedback> feedbackPage = codeFeedbackRepository.findByLanguage(language, pageRequest);

        List<ReadCodeFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(CodeFeedbackConverter::toReadCodeFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadCodeFeedbackListResponseDTO(feedbackList, feedbackPage.getTotalPages());
    }
}
