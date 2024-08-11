package com.example.devcrew.domain.project.dto.response;

import com.example.devcrew.domain.project.entity.Project;
import com.example.devcrew.domain.project.entity.ProjectTag;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostProjectResponse {
    private Long id;

    private String projectName;

    private List<String> images;

    private String teamName;

    private String duration;

    private ProjectTag projectTag;

    private String summary;

    private String role;

    public static PostProjectResponse of(Project project,List<String> images){
        return PostProjectResponse.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .images(images)
                .teamName(project.getTeamName())
                .duration(project.getDuration())
                .projectTag(project.getProjectTag())
                .summary(project.getSummary())
                .role(project.getRole())
                .build();
    }
}
