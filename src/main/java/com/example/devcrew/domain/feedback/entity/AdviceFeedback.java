package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue("ADVICE")
public class AdviceFeedback extends Feedback {

    private static Member member;
    @Enumerated(EnumType.STRING)
    @Column(name = "feedback_tag", nullable = false, length = 20)
    private FeedbackTag feedbackTag;  // 게시글 관련 태그(기획, 디자인, FE, BE, 기타)

    @Builder
    public AdviceFeedback(Long id, String title, String content, String fileUrl, Member member, List<Comment> commentList, List<FeedbackImage> feedbackImageList, FeedbackTag feedbackTag) {
        super(id, title, content, fileUrl, member, commentList, feedbackImageList);
        this.feedbackTag = feedbackTag;
    }

    public void setMember(Member member) {
        super.setMember(member);    // 부모 클래스의 member 필드에 설정
    }

    @PrePersist
    @PreUpdate
    protected void validate() {
        if (this.feedbackTag == null) {
            throw new IllegalArgumentException("현직자 조언 피드백은 feedbackTag 필드가 필수입니다.");
        }
        if (this.getMember() == null) {
            throw new IllegalArgumentException("Member 필드는 null일 수 없습니다.");
        }
    }
}
