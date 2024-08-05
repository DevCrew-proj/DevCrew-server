package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.*;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.Language;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeFeedbackConverter {


    public static Feedback toCodeFeedback(CreateCodeFeedbackRequestDTO request, Member member){

        CodeFeedback codeFeedback = CodeFeedback.builder()
                .language(request.getLanguage())
                .build();

        return Feedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .fileUrl(request.getFileUrl())
                .codeFeedback(codeFeedback)
                .member(member)
                .build();
    }


    public static CreateCodeFeedbackResponseDTO toCreateCodeFeedbackResponseDTO(Feedback feedback){
        return CreateCodeFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .memberId(feedback.getMember().getId())
                .createdAt(feedback.getCreatedAt())
                .updatedAt(feedback.getUpdatedAt())
                .build();
    }


    public static ReadCodeFeedbackResponseDTO toReadCodeFeedbackResponseDTO(Feedback feedback) {
        return ReadCodeFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .title(feedback.getTitle())
                .content(feedback.getContent())
                .memberName(feedback.getMember().getNickname())
                .build();
    }


    public static ReadCodeFeedbackListResponseDTO toReadCodeFeedbackListResponseDTO(Page<Feedback> feedbackPage) {
        List<ReadCodeFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(CodeFeedbackConverter::toReadCodeFeedbackResponseDTO)
                .collect(Collectors.toList());

        return ReadCodeFeedbackListResponseDTO.builder()
                .codeFeedbackList(feedbackList)
                .totalPages(feedbackPage.getTotalPages())
                .build();
    }
}
