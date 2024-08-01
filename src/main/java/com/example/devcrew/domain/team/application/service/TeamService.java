package com.example.devcrew.domain.team.application.service;

import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.repository.ContestRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.domain.team.dto.request.ApplyTeamRequestDTO;
import com.example.devcrew.domain.team.dto.request.CreateTeamRequestDTO;
import com.example.devcrew.domain.team.dto.response.GetMemberInfoResponseDTO;
import com.example.devcrew.domain.team.entity.Team;
import com.example.devcrew.domain.team.entity.TeamMatching;
import com.example.devcrew.domain.team.exception.TeamNotFoundException;
import com.example.devcrew.domain.team.repository.TeamMatchingRepository;
import com.example.devcrew.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor //All 인가 NoArgsConstructor 인가
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMatchingRepository teamMatchingRepository;
    private final ContestRepository contestRepository;

//팀 구성하기
    @Transactional
    public Team createTeamsByContestAndMember(CreateTeamRequestDTO request) {
        Contest contest = contestRepository.findById(request.getContestId())
                //예외처리 추가된거로 수정하기
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공모전입니다."));

                  // (임시) 공모전 테스트용
                  //Optional<Contest> contestOptional = contestRepository.findById(request.getContestId());
                  //Contest contest = contestOptional.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공모전입니다."));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(MemberNotFoundException::new);


        Team team = Team.builder()
                .contest(contest)
                .member(member)
                .name(request.getName())
                .password(request.getPassword())
                .peopleNum(request.getPeopleNum())
                .serviceName(request.getServiceName())
                .planUrl(request.getPlanUrl())
                .equipment(request.getEquipment())
                .os(request.getOs())
                .build();

        team.setMember(member);
        team.setContest(contest);

        return teamRepository.save(team);
    }



    // 멤버 id로 정보 반환
    @Transactional
    public GetMemberInfoResponseDTO GetMemberInfoById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        return new GetMemberInfoResponseDTO(member.getName(), member.getPhoneNumber());
    }

//팀원 신청하기
    @Transactional
    public TeamMatching applyToTeam(ApplyTeamRequestDTO requestDTO) {
        Team team = teamRepository.findByIdAndPassword(requestDTO.getTeamId(), requestDTO.getTeamPassword());
        if (team == null) {
            throw new TeamNotFoundException();
        }

        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        TeamMatching teamMatching = TeamMatching.builder()
                .team(team)
                .member(member)
                .portfolioUrl(requestDTO.getPortfolioUrl())
                .objective(requestDTO.getObjective())
                .build();

        // Save the team matching
        TeamMatching savedTeamMatching = teamMatchingRepository.save(teamMatching);
        System.out.println("Team matching saved with ID: " + savedTeamMatching.getId());

        return savedTeamMatching;
    }
}
