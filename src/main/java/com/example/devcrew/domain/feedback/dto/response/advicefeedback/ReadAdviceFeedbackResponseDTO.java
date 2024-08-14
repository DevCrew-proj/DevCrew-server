package com.example.devcrew.domain.feedback.dto.response.advicefeedback;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadAdviceFeedbackResponseDTO {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private String memberName;
    private String memberImageUrl;

    private List<String> imageUrls;
    private List<String> fileUrls;

    private long commentCount;

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }
}
