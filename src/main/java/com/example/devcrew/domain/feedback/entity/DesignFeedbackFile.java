package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class DesignFeedbackFile extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 대표 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "design_feedback_id", nullable = false)
    private DesignFeedback designFeedback;  // 피드백(게시글) 외래 키

    @Column(nullable = true, length = 255)
    private String fileUrl;    // 파일 URL
}