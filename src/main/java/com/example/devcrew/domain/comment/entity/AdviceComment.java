package com.example.devcrew.domain.comment.entity;

import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AdviceComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // 대표 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advicefeedback_id", nullable = false)
    private AdviceFeedback adviceFeedback;      // 피드백 게시글 외래 키

    @Column(nullable = false, length = 100)
    private String content;     // 댓글 내용


    public void setMembertoComment(Member member) {
        this.member = member;
    }

    public void setFeedbacktoComment(AdviceFeedback adviceFeedback) {
        this.adviceFeedback = adviceFeedback;
    }
}
