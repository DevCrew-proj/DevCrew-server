package com.example.devcrew.domain.team.api;

import com.example.devcrew.domain.team.application.service.TeamService;
import com.example.devcrew.domain.team.dto.request.ApplyTeamRequestDTO;
import com.example.devcrew.domain.team.dto.request.CreateTeamRequestDTO;
import com.example.devcrew.domain.team.dto.response.GetMemberInfoResponseDTO;
import com.example.devcrew.domain.team.entity.Team;
import com.example.devcrew.domain.team.entity.TeamMatching;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

//####### 아직 상단에 뜨는 관련된 공모전 상세 정보는 구현하지 않았음 ######
    @GetMapping("create/{memberId}")
    @Operation(summary = "팀 구성 기능에서 멤버 정보 조회", description = "팀 생성 시 해당 멤버의 이름과 전화번호 반환(자동완성기능).")
    public ResponseEntity<GetMemberInfoResponseDTO> getMemberInfoForCreate(@PathVariable Long memberId) {
        GetMemberInfoResponseDTO response = teamService.GetMemberInfoById();
        return ResponseEntity.ok(response);
    }

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

    @GetMapping("apply/{memberId}")
    @Operation(summary = "팀 신청 기능에서 멤버 정보 조회", description = "팀원 신청서 작성 시 해당 멤버의 이름과 전화번호를 반환합니다.(자동완성기능)")
    public ResponseEntity<GetMemberInfoResponseDTO> getMemberInfoById(@PathVariable Long memberId) {
        try {
            GetMemberInfoResponseDTO response = teamService.GetMemberInfoById();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/apply")
    @Operation(summary = "팀 신청하기")
    public ResponseEntity<TeamMatching> applyTeam(@RequestBody @Valid ApplyTeamRequestDTO applyTeamRequestDTO) {
        try {
            TeamMatching teamMatching = teamService.applyToTeam(applyTeamRequestDTO);
            return ResponseEntity.ok(teamMatching);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }



}