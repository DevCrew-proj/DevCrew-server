package com.example.devcrew.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CompanySize {
    CONGLOMERATE("대기업"),
    SMALL_AND_MID_SIZE_COMAPNY("중소기업"),
    PUBLIC_ENTERPRISE("공공기업"),
    ;

    private final String name;
}
