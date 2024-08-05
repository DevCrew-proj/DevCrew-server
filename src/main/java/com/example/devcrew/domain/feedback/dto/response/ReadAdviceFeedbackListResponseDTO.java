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
public class ReadAdviceFeedbackListResponseDTO {
    private List<ReadAdviceFeedbackResponseDTO> adviceFeedbackList;
    private int totalPages;
}
