package com.example.devcrew.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // MEMBER
    MEMBER_NOT_FOUND_ERROR(404, "회원 정보를 찾지 못했습니다." ),

    //TEAM
    TEAM_NOT_FOUND_ERROR(404, "팀 정보를 찾지 못했습니다." ),
    INVALID_TEAM_PASSWORD(400, "팀 비밀번호가 일치하지 않습니다."),

    //PROJECT
    PROJECT_NOT_FOUND_ERROR(404,"존재하지 않는 프로젝트입니다."),

    //CONTEST
    Contest_NOT_FOUND_ERROR(404,"공모전을 찾지못했습니다."),

    ;

    private final int status;
    private final String errorMessage;
}
