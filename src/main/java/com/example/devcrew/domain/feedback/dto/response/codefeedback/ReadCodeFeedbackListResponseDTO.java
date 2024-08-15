package com.example.devcrew.domain.feedback.dto.response.codefeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadCodeFeedbackListResponseDTO {
    private List<ReadCodeFeedbackResponseDTO> codeFeedbackList;
    private int totalPages;
    private long totalFeedbacks;
}
