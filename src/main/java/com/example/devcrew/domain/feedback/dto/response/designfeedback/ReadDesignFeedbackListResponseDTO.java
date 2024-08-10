package com.example.devcrew.domain.feedback.dto.response.designfeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadDesignFeedbackListResponseDTO {
    private List<ReadDesignFeedbackResponseDTO> designFeedbackList;
    private int totalPages;
}
