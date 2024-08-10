package com.example.devcrew.domain.feedback.dto.response.planfeedback;

import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadPlanFeedbackListResponseDTO {
    private List<ReadPlanFeedbackResponseDTO> planFeedbackList;
    private int totalPages;
}
