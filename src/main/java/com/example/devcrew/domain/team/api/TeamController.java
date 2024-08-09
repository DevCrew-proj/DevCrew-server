package com.example.devcrew.domain.team.api;

import com.example.devcrew.domain.team.dto.request.CreateTeamRequestDTO;
import com.example.devcrew.domain.team.entity.Team;
import com.example.devcrew.domain.team.service.TeamService;
import com.example.devcrew.domain.team.dto.request.ApplyTeamRequestDTO;
import com.example.devcrew.domain.team.dto.response.GetMemberInfoResponseDTO;
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

    @GetMapping("/create")
    @Operation(summary = "팀 구성 기능에서 멤버 정보 조회", description = "팀 생성 시 해당 멤버의 이름과 전화번호 반환(자동완성기능).")
    public GetMemberInfoResponseDTO getMemberInfoForCreate() {
        return teamService.GetMemberInfo();
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new team")
    public Team createTeamsByContestAndMember(@RequestBody @Valid CreateTeamRequestDTO createTeamRequestDTO) {
        return teamService.createTeamsByContestAndMember(createTeamRequestDTO);
    }

    @GetMapping("/apply")
    @Operation(summary = "팀 신청 기능에서 멤버 정보 조회", description = "팀원 신청서 작성 시 해당 멤버의 이름과 전화번호를 반환합니다.(자동완성기능)")
    public GetMemberInfoResponseDTO getMemberInfo() {
        return teamService.GetMemberInfo();
    }

    @PostMapping("/apply")
    @Operation(summary = "팀 신청하기")
    public TeamMatching applyTeam(@RequestBody @Valid ApplyTeamRequestDTO applyTeamRequestDTO) {
        return teamService.applyToTeam(applyTeamRequestDTO);
    }
}