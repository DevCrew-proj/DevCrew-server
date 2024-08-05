package com.example.devcrew.domain.feedback.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FeedbackTag {
    PLAN("기획"),
    DESIGN("디자인"),
    FRONTEND("Frond-end"),
    BACKEND("Back-end"),
    OTHER("기타");
    private final String feedbackTag;
}
