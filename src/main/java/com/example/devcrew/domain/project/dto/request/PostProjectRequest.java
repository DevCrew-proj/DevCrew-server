package com.example.devcrew.domain.project.dto.request;

import com.example.devcrew.domain.project.entity.ProjectTag;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostProjectRequest {

    private String name;

    private String imageUrl;

    private String teamName;

    private String period;

    private ProjectTag projectTag;

    private String summary;

    private String role;
}
