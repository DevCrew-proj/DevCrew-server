package com.example.devcrew.domain.team.api;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.domain.team.application.service.TeamService;
import com.example.devcrew.domain.team.dto.response.GetMemberInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final MemberRepository memberRepository;

    /* 팀 구성하기
    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestParam Long contestId, @RequestParam Long memberId, @RequestBody CreateTeamRequestDTO request) {
        Team team = teamService.CreateTeamsByContestAndMember(contestId, memberId, request);
        return ResponseEntity.ok(team);
    }
    */

    /// PM 이름, 전화번호 응답주기
    // api/team?memberId=1  GET
    @GetMapping
    public ResponseEntity<GetMemberInfoResponseDTO> getMemberInfoById(@RequestParam Long memberId) {
        GetMemberInfoResponseDTO response = teamService.GetMemberInfoById(memberId);
        return ResponseEntity.ok(response);
    }
}