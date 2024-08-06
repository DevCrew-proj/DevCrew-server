package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class AdviceFeedback{

    @Enumerated(EnumType.STRING)
    @Column(name = "feedback_tag", nullable = true, length = 20)
    private FeedbackTag feedbackTag;  // 게시글 관련 태그(기획, 디자인, FE, BE, 기타)

    @Builder
    public AdviceFeedback(FeedbackTag feedbackTag) {
        this.feedbackTag = feedbackTag;
    }

}
