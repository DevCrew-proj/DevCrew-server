package com.example.devcrew.domain.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentResponseDTO {
    private Long id;
    private Long memberId;
    private Long feedbackId;

    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
