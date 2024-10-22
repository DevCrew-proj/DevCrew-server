package com.example.devcrew.domain.feedback.dto.response.advicefeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdviceFeedbackResponseDTO {
    private Long id;
    private Long memberId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
