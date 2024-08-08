package com.example.devcrew.domain.comment.converter;

import com.example.devcrew.domain.comment.dto.request.PostCommentRequestDTO;
import com.example.devcrew.domain.comment.dto.response.GetCommentResponseDTO;
import com.example.devcrew.domain.comment.dto.response.PostCommentResponseDTO;
import com.example.devcrew.domain.comment.dto.response.SingleCommentResponseDTO;
import com.example.devcrew.domain.comment.entity.AdviceComment;
import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.comment.entity.DesignComment;
import com.example.devcrew.domain.comment.entity.PlanComment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentConverter {

    public static CodeComment toCodeComment(PostCommentRequestDTO request) {
        return CodeComment.builder()
                .content(request.getContent())
                .build();
    }

    public static AdviceComment toAdviceComment(PostCommentRequestDTO request) {
        return AdviceComment.builder()
                .content(request.getContent())
                .build();
    }

    public static DesignComment toDesignComment(PostCommentRequestDTO request) {
        return DesignComment.builder()
                .content(request.getContent())
                .build();
    }

    public static PlanComment toPlanComment(PostCommentRequestDTO request) {
        return PlanComment.builder()
                .content(request.getContent())
                .build();
    }


    public static PostCommentResponseDTO toPostCodeCommentResponseDTO(CodeComment comment) {
        return PostCommentResponseDTO.builder()
                .id(comment.getId())
                .memberId(comment.getMember().getId())
                .feedbackId(comment.getCodeFeedback().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static PostCommentResponseDTO toPostAdviceCommentResponseDTO(AdviceComment comment) {
        return PostCommentResponseDTO.builder()
                .id(comment.getId())
                .memberId(comment.getMember().getId())
                .feedbackId(comment.getAdviceFeedback().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static PostCommentResponseDTO toPostDesignCommentResponseDTO(DesignComment comment) {
        return PostCommentResponseDTO.builder()
                .id(comment.getId())
                .memberId(comment.getMember().getId())
                .feedbackId(comment.getDesignFeedback().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static PostCommentResponseDTO toPostPlanCommentResponseDTO(PlanComment comment) {
        return PostCommentResponseDTO.builder()
                .id(comment.getId())
                .memberId(comment.getMember().getId())
                .feedbackId(comment.getPlanFeedback().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static GetCommentResponseDTO toGetCodeCommentResponseDTO(List<CodeComment> comments) {
        List<SingleCommentResponseDTO> commentsDTO = comments.stream()
                .map(comment -> SingleCommentResponseDTO.builder()
                        .id(comment.getId())
                        .memberName(comment.getMember().getNickname())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .updatedAt(comment.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());

        return GetCommentResponseDTO.builder().
                comments(commentsDTO)
                .build();
    }

    public static GetCommentResponseDTO toGetAdviceCommentResponseDTO(List<AdviceComment> comments) {
        List<SingleCommentResponseDTO> commentsDTO = comments.stream()
                .map(comment -> SingleCommentResponseDTO.builder()
                        .id(comment.getId())
                        .memberName(comment.getMember().getNickname())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .updatedAt(comment.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());

        return GetCommentResponseDTO.builder().
                comments(commentsDTO)
                .build();
    }

    public static GetCommentResponseDTO toGetDesignCommentResponseDTO(List<DesignComment> comments) {
        List<SingleCommentResponseDTO> commentsDTO = comments.stream()
                .map(comment -> SingleCommentResponseDTO.builder()
                        .id(comment.getId())
                        .memberName(comment.getMember().getNickname())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .updatedAt(comment.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());

        return GetCommentResponseDTO.builder().
                comments(commentsDTO)
                .build();
    }

    public static GetCommentResponseDTO toGetPlanCommentResponseDTO(List<PlanComment> comments) {
        List<SingleCommentResponseDTO> commentsDTO = comments.stream()
                .map(comment -> SingleCommentResponseDTO.builder()
                        .id(comment.getId())
                        .memberName(comment.getMember().getNickname())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .updatedAt(comment.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());

        return GetCommentResponseDTO.builder().
                comments(commentsDTO)
                .build();
    }


}
