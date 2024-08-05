package com.example.devcrew.domain.contest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateContestResponseDTO {
    private Long contestId;
    private LocalDateTime createdAt;
}