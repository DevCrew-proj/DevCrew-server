package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.feedback.dto.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.CreateCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.Language;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.stereotype.Component;

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
}
