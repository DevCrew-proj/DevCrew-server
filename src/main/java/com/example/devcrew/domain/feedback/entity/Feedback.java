package com.example.devcrew.domain.feedback.entity;


import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Feedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 대표 키

    @Column(nullable = false, length = 50)
    private String title;   // 게시글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 게시글 내용

    @Column(nullable = true, length = 255)
    private String fileUrl; // 첨부 파일 링크

    @Embedded
    private AdviceFeedback adviceFeedback;

    @Embedded
    private CodeFeedback codeFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "feedback", fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "feedback", fetch = FetchType.LAZY)
    private List<FeedbackImage> feedbackImageList = new ArrayList<>();

    public void setMembertoFeedback(Member member) {
        this.member = member;
    }
}
