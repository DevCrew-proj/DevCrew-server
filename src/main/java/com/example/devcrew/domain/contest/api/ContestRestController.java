package com.example.devcrew.domain.contest.api;

import com.example.devcrew.domain.contest.converter.ContestConverter;
import com.example.devcrew.domain.contest.dto.request.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.dto.response.CreateContestResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestDetailResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestListResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestOneResponseDTO;
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
@RequestMapping("/contests")
public class ContestRestController {

    private final ContestCommandService contestCommandService;
    private final ContestQueryService contestQueryService;

    // 공모전 등록
    @PostMapping("/")
    @Operation(summary = "기업 멤버의 공모전 등록", description = "곰모분야 창업부터 기타까지 0~5 순서대로 입니다. poster는 공모전 포스터 이미지파일 S3주소 입니다.")
    public ResponseEntity<CreateContestResponseDTO> createContest(@RequestBody @Valid CreateContestRequestDTO request) {
        Contest contest = contestCommandService.createContestsByMember(request);
        CreateContestResponseDTO response = ContestConverter.toCreateContestResponseDTO(contest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    // 공모전 전체 및 섹터별 조회
    @GetMapping
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

        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort));
        Page<GetContestOneResponseDTO> contestsPage;

        if (sector != null) {
            contestsPage = contestQueryService.findContestsBySector(sector, pageable);
        } else {
            contestsPage = contestQueryService.findAllContests(pageable);
        }

        List<GetContestOneResponseDTO> contests = contestsPage.stream().collect(Collectors.toList());
        GetContestListResponseDTO response = GetContestListResponseDTO.builder()
                .totalResult((int) contestsPage.getTotalElements())
                .contests(contests)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // 공모전 상세조회
    @GetMapping("/{contestId}")
    @Operation(summary = "공모전 상세 조회", description = "공모전 상세 정보를 조회합니다.")
    @Parameters({
            @Parameter(name = "contestId", description = "공모전의 아이디, PathVariable 입니다."),
    })
    public ResponseEntity<GetContestDetailResponseDTO> getContestDetail(@PathVariable Long contestId) {
        GetContestDetailResponseDTO contestDetail = contestQueryService.findContestDetailById(contestId);
        return new ResponseEntity<>(contestDetail, HttpStatus.OK);
    }

}
