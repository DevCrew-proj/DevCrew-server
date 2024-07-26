package com.example.devcrew.domain.project.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateProjectRequest {

    private String name;

    private String imageUrl;

    private String teamName;

    private String period;

    private String projectTag;

    private String summary;

    private String role;
}
