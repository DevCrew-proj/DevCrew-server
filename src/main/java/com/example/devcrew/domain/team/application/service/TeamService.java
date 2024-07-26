package com.example.devcrew.domain.team.application.service;

import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.domain.team.dto.request.CreateTeamRequest;
import com.example.devcrew.domain.team.entity.Team;
import com.example.devcrew.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //All 인가 NoArgsConstructor 인가
public class TeamService {
    private final TeamRepository teamRepository;
    //private final ContestRepository contestRepository;
    //private final MemberRepository memberRepository;


    /* ****** 팀 구성하기  ******

    @Transactional
    public Team CreateTeamsByContestAndMember(Long contestId, Long memberId, CreateTeamRequest request) {
        //Contest contest = contestRepository.findById(contestId)
        //        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공모전입니다."));
        // Member member = MemberRepository.findById(memberId)
        //         .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

          Team team = Team.builder()
                  .contest(contest)
                  .member(member)
                  .name(request.getName())
                  .password(request.getPassword())
                  .peopleNum(request.getPeopleNum())
                  .serviceName(request.getServiceName())
                  .planUrl(request.getPlanUrl())
                  .formDevelop(request.getFormDevelop())
                  .equipment(request.getEquipment())
                  .os(request.getOs())
                  .build();

          return teamRepository.save(team);
    }
*/
}
