package com.example.devcrew.domain.feedback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCodeFeedbackResponseDTO {
    private Long id;
    private Long memberId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
