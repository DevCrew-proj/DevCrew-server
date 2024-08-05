package com.example.devcrew.domain.contest.controller;

import com.example.devcrew.domain.contest.converter.ContestConverter;
import com.example.devcrew.domain.contest.dto.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.dto.CreateContestResponseDTO;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.service.ContestCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contests")
public class ContestRestController {

    private final ContestCommandService contestCommandService;

    // 공모전 등록 API
    @PostMapping("/")
    public ResponseEntity<CreateContestResponseDTO> createContest(@RequestBody @Valid CreateContestRequestDTO request) {
        Contest contest = contestCommandService.createContestsByMember(request);
        CreateContestResponseDTO response = ContestConverter.toCreateContestResponseDTO(contest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
