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
public class SingleCommentResponseDTO {
    private Long id;
    private Long feedbackId;
    private Long memberId;
    private String memberName;
    private String memberImageUrl;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

