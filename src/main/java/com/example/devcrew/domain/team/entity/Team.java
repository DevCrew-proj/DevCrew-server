package com.example.devcrew.domain.team.entity;

import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.entity.NormalMember;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Team extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

// **** Contest, NormalMember FK ****

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contest_id", nullable = false)
    private Contest contest;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


     @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
     private List<TeamMatching> teamMatchingList = new ArrayList<>();


    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String password;

    private Integer peopleNum;

    @Column(length = 30)
    private String serviceName;

    @Column(length = 255)
    private String planUrl;

    //대상 기기 부분 삭제
    //@Column(length = 30)
   // private String formDevelop;

    @Column(length = 50)
    private String equipment;

    @Enumerated(EnumType.STRING)
    private Os os;


}

/*
@JsonIgnore 을 사용하여 순환 참조 문제 해결

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contest_id", nullable = false)
    @JsonIgnore
    private Contest contest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnore
    private Member member;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TeamMatching> teamMatchingList = new ArrayList<>();

    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String password;

    private Integer peopleNum;

    @Column(length = 30)
    private String serviceName;

    @Column(length = 255)
    private String planUrl;

    @Column(length = 50)
    private String equipment;

    @Enumerated(EnumType.STRING)
    private Os os;


 */