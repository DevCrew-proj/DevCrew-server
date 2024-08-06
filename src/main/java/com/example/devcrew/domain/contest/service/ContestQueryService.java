package com.example.devcrew.domain.contest.service;

import com.example.devcrew.domain.contest.dto.response.GetContestDetailResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestOneResponseDTO;
import com.example.devcrew.domain.contest.entity.Sector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContestQueryService {
    public Page<GetContestOneResponseDTO> findAllContests(Pageable pageable);

    public Page<GetContestOneResponseDTO> findContestsBySector(Sector sector, Pageable pageable);

    public GetContestDetailResponseDTO findContestDetailById(Long contestId);
}
