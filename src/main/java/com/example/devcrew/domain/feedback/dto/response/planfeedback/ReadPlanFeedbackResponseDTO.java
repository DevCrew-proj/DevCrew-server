package com.example.devcrew.domain.feedback.dto.response.planfeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadPlanFeedbackResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String memberName;

}