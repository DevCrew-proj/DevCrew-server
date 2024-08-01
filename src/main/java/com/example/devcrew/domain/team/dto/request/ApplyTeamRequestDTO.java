package com.example.devcrew.domain.team.dto.request;

import com.example.devcrew.domain.team.entity.Objective;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyTeamRequestDTO {
    private Long teamId;
    private Long memberId;
    private String teamPassword;
    private String phoneNumber;
    private String portfolioUrl;
    private Objective objective;
}
