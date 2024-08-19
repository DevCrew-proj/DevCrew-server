package com.example.devcrew.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CompanySize {
    CONGLOMERATE("대기업"),
    SMALL_AND_MID_SIZE_COMAPNY("중소기업"),
    PUBLIC_ENTERPRISE("공공기업/공기업"),
    FOREIGN_ENTERPRISE("외국계 기업"),
    NON_PROFIT_ORGANIZATION("비영리 단체"),
    START_UP("비영리 단체"),
    FINANCE("금융권"),
    SCHOOL("학교"),
    ETC("기타")
    ;

    private final String name;
}
