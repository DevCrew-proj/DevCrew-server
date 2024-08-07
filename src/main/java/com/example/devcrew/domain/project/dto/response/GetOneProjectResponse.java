package com.example.devcrew.domain.project.dto.response;

import com.example.devcrew.domain.project.entity.Project;
import com.example.devcrew.domain.project.entity.ProjectTag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetOneProjectResponse {

    private Long id;
    private String projectName;
    private List<String> images;
    private ProjectTag tag;
    private String summary;
    private String teamName;
    private String period;

    public static GetOneProjectResponse of(Project project,List<String> images){
        return GetOneProjectResponse.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .images(images)
                .tag(project.getProjectTag())
                .summary(project.getSummary())
                .teamName(project.getTeamName())
                .period(project.getPeriod())
                .build();
    }

}
