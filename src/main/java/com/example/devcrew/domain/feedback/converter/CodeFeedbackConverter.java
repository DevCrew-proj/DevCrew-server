package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.comment.repository.CodeCommentRepository;
import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.CreateCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeFeedbackConverter {


    public static CodeFeedback toCodeFeedback(CreateCodeFeedbackRequestDTO request, Member member){

        return CodeFeedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .language(request.getLanguage())
                .member(member)
                .build();
    }


    public static CreateCodeFeedbackResponseDTO toCreateCodeFeedbackResponseDTO(CodeFeedback codeFeedback){
        return CreateCodeFeedbackResponseDTO.builder()
                .id(codeFeedback.getId())
                .memberId(codeFeedback.getMember().getId())
                .createdAt(codeFeedback.getCreatedAt())
                .updatedAt(codeFeedback.getUpdatedAt())
                .build();
    }


    public static ReadCodeFeedbackResponseDTO toReadCodeFeedbackResponseDTO(CodeFeedback codeFeedback, long commentCount) {
        return ReadCodeFeedbackResponseDTO.builder()
                .id(codeFeedback.getId())
                .memberId(codeFeedback.getMember().getId())
                .title(codeFeedback.getTitle())
                .content(codeFeedback.getContent())
                .memberName(codeFeedback.getMember().getNickname())
                .memberImageUrl(codeFeedback.getMember().getImageUrl())
                .imageUrls(codeFeedback.getImages().stream()
                        .map(image -> image.getImageUrl())
                        .collect(Collectors.toList()))
                .fileUrls(codeFeedback.getFiles().stream()
                        .map(file -> file.getFileUrl())
                        .collect(Collectors.toList()))
                .commentCount(commentCount)
                .build();
    }


    public static ReadCodeFeedbackListResponseDTO toReadCodeFeedbackListResponseDTO(Page<CodeFeedback> feedbackPage, CodeCommentRepository codeCommentRepository) {
        List<ReadCodeFeedbackResponseDTO> codeFeedbackList = feedbackPage.getContent().stream()
                .map(codeFeedback -> {
                    long commentCount = codeCommentRepository.countByCodeFeedback_Id(codeFeedback.getId());
                    return toReadCodeFeedbackResponseDTO(codeFeedback, commentCount);
                })
                .collect(Collectors.toList());

        return ReadCodeFeedbackListResponseDTO.builder()
                .codeFeedbackList(codeFeedbackList)
                .totalPages(feedbackPage.getTotalPages())
                .build();
    }
}
