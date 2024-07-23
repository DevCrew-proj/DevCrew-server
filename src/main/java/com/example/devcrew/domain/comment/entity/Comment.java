package com.example.devcrew.domain.comment.entity;

import com.example.devcrew.domain.feedback.entity.Feedback;
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "normal_member_id", nullable = false)
//    private NormalMember normalMember;  // 일반 회원 외래 키
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_member_id", nullable = false)
//    private CompanyMember companyMember;    // 기업 회원 외래 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id", nullable = false)
    private Feedback feedback;      // 피드백 게시글 외래 키

    @Column(nullable = false, length = 100)
    private String content;     // 댓글 내용


}
