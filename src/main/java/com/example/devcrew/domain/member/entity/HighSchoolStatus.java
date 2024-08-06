package com.example.devcrew.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum HighSchoolStatus {
    ENROLLMENT("재학"),
    GRADUATION("졸업");

    private final String status;
}