package com.example.devcrew.domain.team.dto.request;

import com.example.devcrew.domain.team.entity.Os;
import lombok.Getter;

@Getter
public class CreateTeamRequest {

    private String name;
    private String password;
    private Integer peopleNum;
    private String serviceName;
    private String planUrl;
    private String formDevelop;
    private String equipment;
    private Os os;

}
