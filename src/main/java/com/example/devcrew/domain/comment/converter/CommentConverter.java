package com.example.devcrew.domain.comment.converter;

import com.example.devcrew.domain.comment.dto.request.PostCommentRequestDTO;
import com.example.devcrew.domain.comment.dto.response.GetCommentResponseDTO;
import com.example.devcrew.domain.comment.dto.response.PostCommentResponseDTO;
import com.example.devcrew.domain.comment.dto.response.SingleCommentResponseDTO;
import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentConverter {

    public static Comment toComment(PostCommentRequestDTO request) {
        return Comment.builder()
                .content(request.getContent())
                .build();
    }


    public static PostCommentResponseDTO toPostCommentResponseDTO(Comment comment) {
        return PostCommentResponseDTO.builder()
                .id(comment.getId())
                .memberId(comment.getMember().getId())
                .feedbackId(comment.getFeedback().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static GetCommentResponseDTO toGetCommentResponseDTO(List<Comment> comments) {
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
