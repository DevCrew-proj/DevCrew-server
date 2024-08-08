package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CodeFeedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 대표 키

    @Column(nullable = false, length = 50)
    private String title;   // 게시글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 게시글 내용

    @Column(nullable = true, length = 255)
    private String fileUrl; // 첨부 파일 링크

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = true, length = 20)
    private Language language;      // 코드 리뷰 관련 태그(JAVA, JS, Kotlin, Python, Swift, C, 기타)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


}

