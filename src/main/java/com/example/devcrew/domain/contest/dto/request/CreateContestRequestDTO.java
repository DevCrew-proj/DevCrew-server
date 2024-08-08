package com.example.devcrew.domain.contest.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateContestRequestDTO {

    private String poster;

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "organization is required")
    private String organization;

    @NotNull(message = "participantTarget is required")
    private String participantTarget;

    @NotNull(message = "award is required")
    private String award;

    @NotNull(message = "homepageUrl is required")
    private String homepageUrl;

    @NotNull(message = "acceptancePeriod is required")
    private String acceptancePeriod;

    @NotNull(message = "sector is required")
    private Integer sector;

    @NotNull(message = "benefits is required")
    private String benefits;

    private String plusBenefits;

    @NotNull(message = "description is required")
    private String description;

    @NotNull(message = "Member ID is required")
    private Long memberId;

}