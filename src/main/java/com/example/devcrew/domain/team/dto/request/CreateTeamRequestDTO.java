package com.example.devcrew.domain.team.dto.request;

import com.example.devcrew.domain.team.entity.Os;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateTeamRequestDTO {
    @NotNull(message = "공모전 아이디.")
    private Long contestId;

    //@NotNull(message = "멤버 아이디.")
    //private Long memberId;

    @NotNull(message = "신청자 정보.")
    private String name;

    @NotNull(message = "팀 이름 ")
    private String teamName;

    @NotNull(message = "팀 비밀번호.")
    private String password;

    @NotNull(message = "인원수.")
    private Integer peopleNum;

    @NotNull(message = "서비스명")
    private String serviceName;

    @NotNull(message = "서비스 기획안 URL")
    private String planUrl;

    //private String formDevelop;

    @NotNull(message = "소요 장비 및 SW")
    private String equipment;

    @NotNull(message = "사용 OS.")
    private Os os;

}
