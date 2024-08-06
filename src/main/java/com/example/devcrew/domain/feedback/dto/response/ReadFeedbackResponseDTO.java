package com.example.devcrew.domain.feedback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadFeedbackResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String memberName;

}
