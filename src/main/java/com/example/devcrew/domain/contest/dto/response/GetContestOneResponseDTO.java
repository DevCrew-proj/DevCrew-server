package com.example.devcrew.domain.contest.dto.response;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetContestOneResponseDTO {

    private String posterUrl;

    private String title;

    private String sector;

    private String organization;

    private String endDate;
}
