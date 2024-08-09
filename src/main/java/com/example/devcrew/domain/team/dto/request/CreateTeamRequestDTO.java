package com.example.devcrew.domain.team.dto.request;

import com.example.devcrew.domain.team.entity.Os;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateTeamRequestDTO {
    @NotNull(message = "공모전 아이디 필수.")
    private Long contestId;

    @NotNull(message = "멤버 아이디 필수.")
    private Long memberId;

    @NotNull(message = "팀 이름을 입력해주세요.")
    private String name;

    @NotNull(message = "팀 비밀번호를 입력해주세요.")
    private String password;

    @NotNull(message = "인원수를 입력해주세요.")
    private Integer peopleNum;

    @NotNull(message = "서비스명을 입력해주세요.")
    private String serviceName;

    @NotNull(message = "서비스 기획안 URL을 입력해주세")
    private String planUrl;

    //private String formDevelop;

    @NotNull(message = "소요 장비 및 SW를 입력해주세요.")
    private String equipment;

    @NotNull(message = "사용 OS를 입력해주세요.")
    private Os os;

}
