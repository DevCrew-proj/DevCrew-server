package com.example.devcrew.domain.contest.converter;

import com.example.devcrew.domain.contest.dto.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.dto.CreateContestResponseDTO;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.entity.Sector;
import com.example.devcrew.domain.member.entity.Member;
import lombok.Setter;

import java.time.LocalDateTime;

public class ContestConverter {

    public static CreateContestResponseDTO toCreateContestResponseDTO(Contest contest) {
        return CreateContestResponseDTO.builder()
                .contestId(contest.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Contest toContest(CreateContestRequestDTO requestDTO, Member member) {

        Sector sector = null;
        //int result = Integer.parseInt(requestDTO.getSector());
        switch (requestDTO.getSector()) {
            case 1:
                sector = Sector.STARTUP;
                break;
            case 2:
                sector = Sector.AI;
                break;
            case 3:
                sector = Sector.PLATFORM;
                break;
            case 4:
                sector = Sector.DATAALALYSIS;
                break;
            case 5:
                sector = Sector.GAME;
                break;
            case 6:
                sector = Sector.OTHER;
                break;
        }

        return Contest.builder()
                .posterUrl(requestDTO.getPoster())
                .title(requestDTO.getTitle())
                .organization(requestDTO.getOrganization())
                .participantTarget(requestDTO.getParticipantTarget())
                .award(requestDTO.getAward())
                .homepageUrl(requestDTO.getHomepageUrl())
                .acceptancePeriod(requestDTO.getAcceptancePeriod())
                .sector(sector)
                .benefits(requestDTO.getBenefits())
                .plusBenefits(requestDTO.getPlusBenefits())
                .description(requestDTO.getDescription())
                .member(member)
                .build();
    }
}