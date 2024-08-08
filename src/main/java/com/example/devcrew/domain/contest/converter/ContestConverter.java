package com.example.devcrew.domain.contest.converter;

import com.example.devcrew.domain.contest.dto.request.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.dto.response.CreateContestResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestDetailResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestOneResponseDTO;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.entity.Sector;
import com.example.devcrew.domain.member.entity.CompanyMember;
import com.example.devcrew.domain.member.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContestConverter {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static CreateContestResponseDTO toCreateContestResponseDTO(Contest contest) {
        return CreateContestResponseDTO.builder()
                .contestId(contest.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Contest toContest(CreateContestRequestDTO requestDTO, Member member) {

        return Contest.builder()
                .posterUrl(requestDTO.getPoster())
                .title(requestDTO.getTitle())
                .organization(requestDTO.getOrganization())
                .participantTarget(requestDTO.getParticipantTarget())
                .award(requestDTO.getAward())
                .homepageUrl(requestDTO.getHomepageUrl())
                .acceptancePeriod(requestDTO.getAcceptancePeriod())
                .sector(requestDTO.getSector())
                .benefits(requestDTO.getBenefits())
                .plusBenefits(requestDTO.getPlusBenefits())
                .description(requestDTO.getDescription())
                .member(member)
                .build();
    }


    public static GetContestOneResponseDTO toGetContestOneResponseDTO(Contest contest) {
        String endDate = extractEndDate(contest.getAcceptancePeriod());

        return GetContestOneResponseDTO.builder()
                .posterUrl(contest.getPosterUrl())
                .title(contest.getTitle())
                .sector(contest.getSector().getSector())
                .organization(contest.getOrganization())
                .endDate(endDate)
                .build();
    }

    private static String extractEndDate(String acceptancePeriod) {
        if (acceptancePeriod == null || !acceptancePeriod.contains("~")) {
            throw new IllegalArgumentException("Invalid acceptancePeriod format");
        }
        return acceptancePeriod.split("~")[1].trim();
    }



    public static GetContestDetailResponseDTO toGetContestDetailResponseDTO(Contest contest, Member member) {

        String[] periods = contest.getAcceptancePeriod().split(" ~ ");
        LocalDate endDate = LocalDate.parse(periods[1], DATE_FORMATTER);

        // 공모전 남은기간 계산
        LocalDate today = LocalDate.now();
        long daysRemaining = ChronoUnit.DAYS.between(today, endDate);

        String remainingPeriod;

        if (daysRemaining >= 0) {
            remainingPeriod = String.valueOf(daysRemaining);
        } else {
            remainingPeriod = "Expired";
        }

        CompanyMember companyMember = member.getCompanyMember();
        String ceoName = getCeoName(companyMember);
        String ceoPhoneNum = getContactNumber(companyMember);


        return GetContestDetailResponseDTO.builder()
                .poster(contest.getPosterUrl())
                .title(contest.getTitle())
                .organization(contest.getOrganization())
                .participantTarget(contest.getParticipantTarget())
                .award(contest.getAward())
                .homepageUrl(contest.getHomepageUrl())
                .remainingPeriod(remainingPeriod)
                .acceptancePeriod(contest.getAcceptancePeriod())
                .sector(contest.getSector().getSector())
                .benefits(contest.getBenefits())
                .plusBenefits(contest.getPlusBenefits())
                .description(contest.getDescription())
                .ceoName(ceoName)
                .ceoPhoneNum(ceoPhoneNum)
                .ceoEmail(member.getEmail())
                .build();
    }

    private static String getCeoName(CompanyMember companyMember) {
        if (companyMember != null) {
            return companyMember.getCeoName();
        }
        return "담당자 이름을 찾을 수 없습니다.";
    }

    private static String getContactNumber(CompanyMember companyMember) {
        if (companyMember != null) {
            return companyMember.getContactNumber();
        }
        return "담당자 번호를 찾을 수 없습니다.";
    }
}