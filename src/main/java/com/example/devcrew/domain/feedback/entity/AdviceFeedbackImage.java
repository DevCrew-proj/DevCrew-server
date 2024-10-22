package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdviceFeedbackImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 대표 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advice_feedback_id", nullable = false)
    private AdviceFeedback adviceFeedback;  // 피드백(게시글) 외래 키

    @Column(nullable = true, length = 255)
    private String imageUrl;    // 이미지 URL

}
