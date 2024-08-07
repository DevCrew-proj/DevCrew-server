package com.example.devcrew.domain.project.entity;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProjectImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public static ProjectImage of(String imageUrl,Project project){
        return ProjectImage.builder()
                .imageUrl(imageUrl)
                .project(project)
                .build();
    }


}

