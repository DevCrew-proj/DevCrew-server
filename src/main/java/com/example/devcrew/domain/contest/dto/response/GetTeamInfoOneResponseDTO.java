package com.example.devcrew.domain.contest.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetTeamInfoOneResponseDTO {

    private Long teamId;
    private String teamName;
    private String planUrl;
    private String teamEmail;
}
