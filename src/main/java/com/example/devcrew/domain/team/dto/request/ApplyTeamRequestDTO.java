package com.example.devcrew.domain.team.dto.request;

import com.example.devcrew.domain.team.entity.Objective;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyTeamRequestDTO {
    //@NotNull(message = "팀 아이디 필수.")
    //private Long teamId;
    //@NotNull(message = "멤버 아이디 필수.")
    //private Long memberId;

    @NotNull(message = "팀 이름  필수.")
    private String teamName;

    @NotNull(message = "팀 비밀번호를 입력해주세요.")
    private String teamPassword;

    private String name;

    //private String phoneNumber;

    @NotNull(message = "포트폴리오 URL을 입력해주세요.")
    private String portfolioUrl;
    @NotNull(message = "팀 목표를 입력해주세요.")
    private Objective objective;
}
