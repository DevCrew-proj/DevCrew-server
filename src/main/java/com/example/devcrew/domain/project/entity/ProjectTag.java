package com.example.devcrew.domain.project.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProjectTag {

    STARTUP("창업"),
    GENERATIVE_AI("생산형 AI"),
    PLATFORM("플랫폼"),
    DATA_ANALYSIS("데이터 분석"),
    GAME("게임"),
    OTHERS("기타");

    private final String tag;

}
