package com.example.devcrew.domain.feedback.entity;

import com.example.devcrew.domain.comment.entity.Comment;
import com.example.devcrew.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CodeFeedback {

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false, length = 20)
    private Language language;      // 코드 리뷰 관련 태그(JAVA, JS, Kotlin, Python, Swift, C, 기타)

    @Builder
    public CodeFeedback(Language language) {
        this.language = language;
    }
}

