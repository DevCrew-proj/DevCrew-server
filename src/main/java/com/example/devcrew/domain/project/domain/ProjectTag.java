package com.example.devcrew.domain.project.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProjectTag {
    GENERATIVE_AI("생산형 AI"),
    E_COMMERCE("이커머스"),
    COMMUNITY("커뮤니티"),
    PLATFORM("플랫폼"),
    OTHERS("기타");

    private final String tag;

}
