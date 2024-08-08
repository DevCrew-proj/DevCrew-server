package com.example.devcrew.domain.team.application.service;

import com.example.devcrew.domain.contest.entity.Contest;
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
import com.example.devcrew.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMatchingRepository teamMatchingRepository;
    //private final ContestRepository contestRepository;
    private final AuthService authService;

/*
    @Transactional
    public Team createTeamsByContestAndMember(CreateTeamRequestDTO request) {
        Contest contest = contestRepository.findById(request.getContestId())
                //예외처리 추가된거로 수정하기
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공모전입니다."));

                  // 테스트용
                  //Optional<Contest> contestOptional = contestRepository.findById(request.getContestId());
                  //Contest contest = contestOptional.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공모전입니다."));

        //Member member = memberRepository.findById(request.getMemberId())
         //       .orElseThrow(MemberNotFoundException::new);
        Member member = authService.getLoginUser();

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

*/

    @Transactional
    public GetMemberInfoResponseDTO GetMemberInfoById(Long memberId) {
        Member member = authService.getLoginUser();
        return new GetMemberInfoResponseDTO(member.getName(), member.getNormalMember().getPhoneNumber());
    }

@Transactional
public TeamMatching applyToTeam(ApplyTeamRequestDTO requestDTO) {
    Team team = teamRepository.findByIdAndPassword(requestDTO.getTeamId(),  requestDTO.getTeamPassword())
            .orElseThrow(TeamNotFoundException::new);
     //Member member = memberRepository.findById(requestDTO.getMemberId())
      //      .orElseThrow(MemberNotFoundException::new);
    Member member = authService.getLoginUser();

    TeamMatching teamMatching = TeamMatching.builder()
            .team(team)
            .member(member)
            .portfolioUrl(requestDTO.getPortfolioUrl())
            .objective(requestDTO.getObjective())
            .build();

    return teamMatchingRepository.save(teamMatching);
}
}