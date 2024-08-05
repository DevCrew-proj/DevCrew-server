package com.example.devcrew.domain.comment.entity;

import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // 대표 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id", nullable = false)
    private Feedback feedback;      // 피드백 게시글 외래 키

    @Column(nullable = false, length = 100)
    private String content;     // 댓글 내용


    public void setMembertoComment(Member member) {
        this.member = member;
    }

    public void setFeedbacktoComment(Feedback feedback) {
        this.feedback = feedback;
    }
}
