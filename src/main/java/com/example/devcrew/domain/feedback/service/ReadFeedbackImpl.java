package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.FeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
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
public class ReadFeedbackImpl {
    private final FeedbackRepository feedbackRepository;

    @Transactional
    public ReadFeedbackResponseDTO readFeedback(Long feedbackId){
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return FeedbackConverter.toReadFeedbackResponseDTO(feedback);
    }

    @Transactional
    public ReadFeedbackListResponseDTO readFeedbackList(int page){
        PageRequest pageRequest = PageRequest.of(page, 4);

        Page<Feedback> feedbackPage = feedbackRepository.findAll(pageRequest);

        List<ReadFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(FeedbackConverter::toReadFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadFeedbackListResponseDTO(feedbackList, feedbackPage.getTotalPages());
    }

}
