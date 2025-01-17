package com.example.devcrew.domain.member.entity;

import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.project.entity.Project;
import com.example.devcrew.domain.team.entity.Team;
import com.example.devcrew.domain.team.entity.TeamMatching;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;
    private String password;
    private String name;

    private String nickname;
    private String email;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private CompanyMember companyMember;

    @Embedded
    private NormalMember normalMember;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Contest> contestList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Team> teamList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<TeamMatching> teamMatchingList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();


    public void updateRole(Role role) {
        this.role = role;
    }

    public void updateRoleCompanyMember() {
        this.role = Role.COMPANY_USER;
    }

    public void updateCompanyMember(CompanyMember companyMember) {
        this.companyMember = companyMember;
    }

    public void updateMemberProfile(PostMemberProfileRequest request) {
        this.name = request.getName();
        this.imageUrl = request.getImageUrl();
        this.normalMember = new NormalMember();
        this.normalMember.updateNormalMemberProfile(request);

    }

    public void initializeNormalMember(){
        this.normalMember = new NormalMember();
    }
}


