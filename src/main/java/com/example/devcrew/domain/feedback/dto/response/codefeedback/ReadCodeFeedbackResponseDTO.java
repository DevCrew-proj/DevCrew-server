package com.example.devcrew.domain.feedback.dto.response.codefeedback;

import com.example.devcrew.domain.feedback.entity.Language;
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
    private Long memberId;
    private String title;
    private String content;
    private String memberName;
    private String memberImageUrl;

    private List<String> imageUrls;
    private List<String> fileUrls;

    private long commentCount;

    private String language;

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }
}
