package com.example.devcrew.domain.team.service;

import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.exception.ContestNotFoundException;
import com.example.devcrew.domain.contest.repository.ContestRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.domain.team.dto.request.ApplyTeamRequestDTO;
import com.example.devcrew.domain.team.dto.request.CreateTeamRequestDTO;
import com.example.devcrew.domain.team.dto.response.GetMemberInfoResponseDTO;
import com.example.devcrew.domain.team.entity.Team;
import com.example.devcrew.domain.team.entity.TeamMatching;
import com.example.devcrew.domain.team.exception.InvalidTeamPasswordException;
import com.example.devcrew.domain.team.exception.TeamNotFoundException;
import com.example.devcrew.domain.team.repository.TeamMatchingRepository;
import com.example.devcrew.domain.team.repository.TeamRepository;
import com.example.devcrew.domain.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMatchingRepository teamMatchingRepository;
    private final ContestRepository contestRepository;
    private final AuthService authService;


    @Transactional
    public Team createTeamsByContestAndMember(CreateTeamRequestDTO request) {

        Contest contest = contestRepository.findById(request.getContestId())
                .orElseThrow(ContestNotFoundException::new);

        Member member = authService.getLoginUser();

        Team team = Team.builder()
                .contest(contest)
                .member(member)
                .name(request.getName())
                .teamName(request.getTeamName())
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

    @Transactional
    public GetMemberInfoResponseDTO GetMemberInfo() {
        Member member = authService.getLoginUser();
        String memberName = member.getName();
        if(memberName == null) {
            return null;
        }
        return new GetMemberInfoResponseDTO(memberName);
    }

    @Transactional
    public TeamMatching applyToTeam(ApplyTeamRequestDTO requestDTO) {
        //팀명, 팀 패스워드에 일치하는 팀 찾기
        Team team = teamRepository.findByNameAndPassword(requestDTO.getTeamName(), requestDTO.getTeamPassword())
                .orElseThrow(TeamNotFoundException::new);

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
