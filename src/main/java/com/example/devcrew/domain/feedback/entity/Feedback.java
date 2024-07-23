package com.example.devcrew.domain.feedback.entity;


import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Feedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 대표 키

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "normal_member_id", nullable = false)
//    private NormalMember normalMember;  // 일반 회원 외래 키
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_member_id", nullable = false)
//    private CompanyMember companyMember;    // 기업 회원 외래 키

    @Column(nullable = false, length = 50)
    private String title;   // 게시글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 게시글 내용

    @Column(nullable = true, length = 255)
    private String fileUrl; // 첨부 파일 링크

    @Enumerated(EnumType.STRING)
    @Column(name = "feedback_tag", nullable = false, length = 20)
    private FeedbackTag feedbackTag;    // 게시글 관련 태그(기획, 디자인, FE, BE, 코드리뷰, 기타)

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false, length = 20)
    private Language language;      // 코드 리뷰 관련 태그(JAVA, JS, Kotlin, Python, Swift, C, 기타)
}
