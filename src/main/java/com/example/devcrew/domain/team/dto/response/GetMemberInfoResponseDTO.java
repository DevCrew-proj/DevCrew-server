package com.example.devcrew.domain.team.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberInfoResponseDTO {

    private String name;
    private String phoneNumber;

}
