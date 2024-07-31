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

    private String name;

    private String teamName;

    private String period;

    private ProjectTag projectTag;

    private String summary;

    private String role;


    public static PostProjectResponse from(Project project){
        return PostProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .teamName(project.getTeamName())
                .period(project.getPeriod())
                .projectTag(project.getProjectTag())
                .summary(project.getSummary())
                .role(project.getRole())
                .build();
    }
}
