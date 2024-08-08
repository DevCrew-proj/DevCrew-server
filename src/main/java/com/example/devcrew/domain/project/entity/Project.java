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

    private String name;

    private String teamName;

    private String period;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private ProjectTag projectTag;

    private String summary;

    private String role;

    private String imageUrl;

//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
//    private List<ProjectImage> projectImages=new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


    public static Project of(Member member, PostProjectRequest request){
        return Project.builder()
                .name(request.getName())
                .teamName(request.getTeamName())
                .period(request.getPeriod())
                .projectTag(request.getProjectTag())
                .summary(request.getSummary())
                .role(request.getRole())
                .imageUrl(request.getImageUrl())
                .member(member)
                .build();
    }


}
