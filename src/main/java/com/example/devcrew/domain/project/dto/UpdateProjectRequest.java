package com.example.devcrew.domain.project.dto;

import com.example.devcrew.domain.project.domain.ProjectTag;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
