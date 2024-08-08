package com.example.devcrew.domain.contest.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetContestDetailResponseDTO {

    private String poster;

    private String title;

    private String organization;

    private String participantTarget;

    private String award;

    private String homepageUrl;

    private String remainingPeriod; // 남은 기간

    private String acceptancePeriod; // 접수 기간

    private String sector;

    private String benefits;

    private String plusBenefits;

    private String description;

    private String ceoName;

    private String ceoPhoneNum;

    private String ceoEmail;

}
