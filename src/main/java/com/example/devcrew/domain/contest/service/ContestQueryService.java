package com.example.devcrew.domain.contest.service;

import com.example.devcrew.domain.contest.dto.response.*;
import com.example.devcrew.domain.contest.entity.Sector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContestQueryService {
    public Page<GetContestOneResponseDTO> findAllContests(Pageable pageable);

    public Page<GetContestOneResponseDTO> findContestsBySector(Sector sector, Pageable pageable);

    public GetContestDetailResponseDTO findContestDetailById(Long contestId);

    public GetContestListResponseDTO getContests(Sector sector, int page, int size, String sort, String order);

    public GetTeamInfoListResponseDTO findTeamsInContest(Long contestId);
    }
