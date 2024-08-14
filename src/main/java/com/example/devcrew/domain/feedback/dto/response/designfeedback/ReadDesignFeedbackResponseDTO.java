package com.example.devcrew.domain.feedback.dto.response.designfeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadDesignFeedbackResponseDTO {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private String memberName;
    private String memberImageUrl;

    private List<String> imageUrls;
    private List<String> fileUrls;

    private long commnetCount;

    public void setCommnetCount(long commentCount) {
        this.commnetCount = commentCount;
    }

}
