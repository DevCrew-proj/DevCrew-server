package com.example.devcrew.domain.contest.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sector {
    STARTUP("창업"),
    AI("생성형 AI"),
    PLATFORM("플랫폼"),
    DATAALALYSIS("데이터분석"),
    GAME("게임"),
    OTHER("기타");

    private final String sector;
}
