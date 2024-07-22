package com.example.devcrew.domain.project.dto;

import com.example.devcrew.domain.project.domain.ProjectTag;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateProjectRequest {
    private String  projectTag;

    private String summary;

    private String teamName;

    private String role;

    private String period;
}
