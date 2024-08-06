package com.example.devcrew.domain.feedback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadFeedbackListResponseDTO {
    private List<ReadFeedbackResponseDTO> feedbackList;
    private int totalPages;
}
