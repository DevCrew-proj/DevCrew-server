package com.example.devcrew.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // MEMBER
    MEMBER_NOT_FOUND_ERROR(404, "회원 정보를 찾지 못했습니다." ),

    //TEAM
    TEAM_NOT_FOUND_ERROR(404, "팀 정보를 찾지 못했습니다." )
    ;

    private final int status;
    private final String errorMessage;
}
