package com.example.devcrew.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // MEMBER
    MEMBER_NOT_FOUND_ERROR(404, "회원 정보를 찾지 못했습니다." ),
    NOT_COMPANY_USER_ERROR(403, "공모전 등록 권한이 없습니다. 회사 회원만 공모전을 등록할 수 있습니다."),


    //TEAM
    TEAM_NOT_FOUND_ERROR(404, "팀 정보를 찾지 못했습니다." ),
    INVALID_TEAM_PASSWORD(400, "팀 비밀번호가 일치하지 않습니다."),
    DUPLICATE_TEAM(404, "동일한 이름의 팀이 존재합니다."),

    //PROJECT
    PROJECT_NOT_FOUND_ERROR(404,"해당 멤버와 매핑되는 프로젝트가 없습니다."),

    //CONTEST
    CONTEST_NOT_FOUND_ERROR(404,"해당 분야의 공모전이 더 이상 존재하지 않습니다."),
    INVALID_ACCEPTANCE_PERIOD(400,"공모전 기간 입력이 잘못되었습니다. ex) 2024-08-01 ~ 2024-08-31 이와 같은 형식으로 입력해주세요. '~' 양쪽에 공백있습니다."),

    // FEEDBACK
    FEEDBACK_NOT_FOUND_ERROR(404, "피드백 정보를 찾지 못했습니다."),

    // COMMENT
    COMMENT_MEMBER_NOT_FOUND_ERROR(404, "댓글 작성자를 찾지 못했습니다."),
    COMMENT_FEEDBACK_NOT_FOUND_ERROR(404, "해당 피드백에 대한 댓글을 찾지 못했습니다."),
    ;

    private final int status;
    private final String errorMessage;
}
