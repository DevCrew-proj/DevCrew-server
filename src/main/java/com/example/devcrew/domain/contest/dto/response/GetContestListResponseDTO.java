package com.example.devcrew.domain.contest.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetContestListResponseDTO {

    private int totalResult;

    private int totalPages;

    private List<GetContestOneResponseDTO> contests;

}
