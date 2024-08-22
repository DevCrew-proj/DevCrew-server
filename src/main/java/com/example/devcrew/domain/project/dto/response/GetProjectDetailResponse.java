package com.example.devcrew.domain.project.dto.response;

import com.example.devcrew.domain.project.entity.Project;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetProjectDetailResponse {

    private Long id;

    private String name;

    private String tag;

    private String oneLineSummary;

    private String summary;

    private String teamName;

    private String role;

    private String duration;

    public static GetProjectDetailResponse from (Project project){
        return GetProjectDetailResponse.builder()
                .id(project.getId())
                .name(project.getProjectName())
                .tag(project.getProjectTag().getTag())
                .oneLineSummary(project.getOneLineSummary())
                .summary(project.getSummary())
                .teamName(project.getTeamName())
                .role(project.getRole())
                .duration(project.getDuration())
                .build();
    }
}
