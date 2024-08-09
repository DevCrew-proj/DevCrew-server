package com.example.devcrew.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CollegeStatus {

    ENROLLMENT("재학"),
    ON_LEAVE("휴학"),
    GRADUATION("졸업");

    private final String status;
}

