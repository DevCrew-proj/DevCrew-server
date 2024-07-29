package com.example.devcrew.domain.team.api;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.domain.team.application.service.TeamService;
import com.example.devcrew.domain.team.dto.request.CreateTeamRequestDTO;
import com.example.devcrew.domain.team.dto.response.GetMemberInfoResponseDTO;
import com.example.devcrew.domain.team.entity.Team;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final MemberRepository memberRepository;
/*
    @PostMapping("/create")
    @Operation(summary = "Create a new team")
    public ResponseEntity<Team> createTeamsByContestAndMember(@RequestBody CreateTeamRequestDTO createTeamRequestDTO) {
        try {
            Team team = teamService.createTeamsByContestAndMember(createTeamRequestDTO);
            return ResponseEntity.ok(team);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
*/

    /// PM 이름, 전화번호 응답주기

    @GetMapping
    @Operation(summary = "멤버 정보 자동완성", description = "팀 구성 신청서 작성 시 해당 멤버의 이름과 전화번호를 반환합니다.")
    public ResponseEntity<GetMemberInfoResponseDTO> getMemberInfoById(@RequestParam Long memberId) {
        GetMemberInfoResponseDTO response = teamService.GetMemberInfoById(memberId);
        return ResponseEntity.ok(response);
    }
}