package com.example.devcrew.domain.feedback.dto.response.codefeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadCodeFeedbackResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String memberName;

    private List<String> imageUrls;
    private List<String> fileUrls;
}
