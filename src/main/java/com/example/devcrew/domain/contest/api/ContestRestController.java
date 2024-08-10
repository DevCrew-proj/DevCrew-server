package com.example.devcrew.domain.contest.api;

import com.example.devcrew.domain.contest.converter.ContestConverter;
import com.example.devcrew.domain.contest.dto.request.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.dto.response.*;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.entity.Sector;
import com.example.devcrew.domain.contest.service.ContestCommandService;
import com.example.devcrew.domain.contest.service.ContestQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Tag(name = "[공모전]")
@RequestMapping("/v1/contests")
public class ContestRestController {

    private final ContestCommandService contestCommandService;
    private final ContestQueryService contestQueryService;

    @PostMapping("/")
    @Operation(summary = "기업 멤버의 공모전 등록", description = "공모분야는 STARTUP(창업), AI(생성형 AI), PLATFORM(플랫폼), DATAALALYSIS(데이터분석), GAME(게임), OTHER(기타)입니다. poster는 공모전 포스터 이미지파일 S3주소 입니다.")
    public ResponseEntity<CreateContestResponseDTO> createContest(@RequestBody @Valid CreateContestRequestDTO request) {
        Contest contest = contestCommandService.createContestsByMember(request);
        CreateContestResponseDTO response = ContestConverter.toCreateContestResponseDTO(contest);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/")
    @Operation(summary = "공모전 전체 및 섹터별 조회", description = "공모전을 페이지별로 조회합니다. 섹터를 지정하면 해당 섹터의 공모전만 조회합니다. 페이지는 0부터 시작합니다.")
    @Parameters({
            @Parameter(name = "order", description = "기본적으로 desc(내림차순) 상태이며 desc로 입력되지 않으면 Asc(오름차순) 상태가 됩니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<GetContestListResponseDTO> getContests(
            @RequestParam(value = "sector", required = false) Sector sector,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "createdAt") String sort,
            @RequestParam(value = "order", defaultValue = "desc") String order) {

        GetContestListResponseDTO response = contestQueryService.getContests(sector, page, size, sort, order);
//        return new ResponseEntity<>(response, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{contestId}")
    @Operation(summary = "공모전 상세 조회", description = "공모전 상세 정보를 조회합니다.")
    @Parameters({
            @Parameter(name = "contestId", description = "공모전의 아이디, PathVariable 입니다."),
    })
    public ResponseEntity<GetContestDetailResponseDTO> getContestDetail(@PathVariable Long contestId) {
        GetContestDetailResponseDTO contestDetail = contestQueryService.findContestDetailById(contestId);
//        return new ResponseEntity<>(contestDetail, HttpStatus.OK);
        return ResponseEntity.ok(contestDetail);
    }


    @GetMapping("/{contestId}/teams")
    @Operation(summary = "공모전 매칭 팀 정보 조회", description = "한 공모전에서 매칭 중인 팀 정보를 조회할 수 있습니다.")
    @Parameters({
            @Parameter(name = "contestId", description = "공모전의 아이디, PathVariable 입니다."),
    })
    public ResponseEntity<GetTeamInfoListResponseDTO> getTeamsInContest(@PathVariable Long contestId) {
        GetTeamInfoListResponseDTO teamInfoList = contestQueryService.findTeamsInContest(contestId);
//        return new ResponseEntity<>(teamInfoList, HttpStatus.OK);
        return ResponseEntity.ok(teamInfoList);
    }

}
