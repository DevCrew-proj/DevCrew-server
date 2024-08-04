package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.*;
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

    // DTO to Entity

    // 코드 리뷰 게시글 생성 요청
    public static Feedback toCodeFeedback(CreateCodeFeedbackRequestDTO request, Member member){

        Language language = switch (request.getLanguage()){
            case 1 -> Language.JAVA;
            case 2 -> Language.JAVASCRIPT;
            case 3 -> Language.KOTLIN;
            case 4 -> Language.PYTHON;
            case 5 -> Language.SWIFT;
            case 6 -> Language.C;
            case 7 -> Language.OTHER;
            default -> throw new IllegalArgumentException("Unknown language: " + request.getLanguage());
        };

        CodeFeedback codeFeedback = CodeFeedback.builder()
                .language(language)
                .build();

        return Feedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .fileUrl(request.getFileUrl())
                .codeFeedback(codeFeedback)
                .member(member)
                .build();
    }
    
    // 코드 리뷰 게시글 생성 응답
    public static CreateCodeFeedbackResponseDTO toCreateCodeFeedbackResponseDTO(Feedback feedback){
        return CreateCodeFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .memberId(feedback.getMember().getId())
                .createdAt(feedback.getCreatedAt())
                .updatedAt(feedback.getUpdatedAt())
                .build();
    }

    // 게시글 단일 조회 응답
    public static ReadCodeFeedbackResponseDTO toReadCodeFeedbackResponseDTO(Feedback feedback) {
        return ReadCodeFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .title(feedback.getTitle())
                .content(feedback.getContent())
                .memberName(feedback.getMember().getNickname())
                .build();
    }

    // 게시글 목록 조회 응답
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
