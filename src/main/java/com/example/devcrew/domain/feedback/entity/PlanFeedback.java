package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PlanFeedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;   // 게시글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 게시글 내용

    @Column(nullable = true, length = 255)
    private String fileUrl; // 첨부 파일 링크

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "planFeedback", cascade = CascadeType.ALL)
    private List<PlanFeedbackFile> files;  // 파일 URL 리스트

    @OneToMany(mappedBy = "planFeedback", cascade = CascadeType.ALL)
    private List<PlanFeedbackImage> images; // 이미지 URL 리스트


}
