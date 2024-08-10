package com.example.devcrew.domain.project.entity;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.project.dto.request.PostProjectRequest;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Project extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String period;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private ProjectTag projectTag;

    private String summary;

    private String role;

    @Column(nullable = false)
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectImage> projectImages;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


    public static Project of(Member member, PostProjectRequest request){
        return Project.builder()
                .projectName(request.getProjectName())
                .teamName(request.getTeamName())
                .period(request.getPeriod())
                .projectTag(request.getProjectTag())
                .summary(request.getSummary())
                .role(request.getRole())
                .member(member)
                .build();
    }


}
