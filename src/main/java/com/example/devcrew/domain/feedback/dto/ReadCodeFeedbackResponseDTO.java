package com.example.devcrew.domain.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadCodeFeedbackResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String memberName;

    // 댓글 카운터도 구현해야 함
}
