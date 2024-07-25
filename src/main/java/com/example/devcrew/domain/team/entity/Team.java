package com.example.devcrew.domain.team.entity;

import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Team")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Team extends BaseTimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/* **** Contest, NormalMember FK ****

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "contest_id", nullable = false)
    private Contest contestId;


    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "normal_member_id", nullable = false)
    private NormalMember normalMemberId;

*/

    // @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    // private List<TeamMatching> teamMatchingId;


    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String password;

    private Integer peopleNum;

    @Column(length = 30)
    private String serviceName;

    @Column(length = 255)
    private String planUrl;

    @Column(length = 30)
    private String formDevelop;

    @Column(length = 50)
    private String equipment;

    @Enumerated(EnumType.STRING)
    private Os os;



}
