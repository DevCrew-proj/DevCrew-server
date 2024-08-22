package com.example.devcrew.domain.project.dto.request;

import com.example.devcrew.domain.project.entity.ProjectTag;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostProjectRequest {

    private String projectName;

    private List<String> images;

    private String teamName;

    private String duration;

    private ProjectTag projectTag;

    private String oneLineSummary;

    private String summary;

    private String role;

}
