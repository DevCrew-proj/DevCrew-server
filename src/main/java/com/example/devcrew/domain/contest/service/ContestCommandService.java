package com.example.devcrew.domain.contest.service;

import com.example.devcrew.domain.contest.dto.request.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.entity.Contest;

public interface ContestCommandService {
    Contest createContestsByMember(CreateContestRequestDTO request);
}