package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("CODE_REVIEW")
public class CodeFeedback extends Feedback{

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false, length = 20)
    private Language language;      // 코드 리뷰 관련 태그(JAVA, JS, Kotlin, Python, Swift, C, 기타)

    @Builder
    public CodeFeedback(Long id, String title, String content, String fileUrl, Member member, List<Comment> commentList, List<FeedbackImage> feedbackImageList, Language language) {
        super(id, title, content, fileUrl, member, commentList, feedbackImageList);
        this.language = language;
    }

    // 유효성 검사
    @PrePersist
    @PreUpdate
    protected void validate() {
        if (this.language == null) {
            throw new IllegalArgumentException("코드 리뷰 피드백은 language 필드가 필수입니다.");
        }
    }
}

