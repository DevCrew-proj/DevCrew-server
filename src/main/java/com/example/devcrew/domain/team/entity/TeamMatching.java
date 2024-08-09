package com.example.devcrew.domain.team.entity;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TeamMatching")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeamMatching extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "team_id", nullable = false)
     private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    /* 일반 회원 테이블과 N:1 매핑
        @ManyToOne(fetch = FetchType.LAZY)
        @Column(nullable = false)
        private Member? normalMemberId;
    */
    @JoinColumn(name = "portfolio_url", nullable = false)
    private String portfolioUrl;

    @Enumerated(EnumType.STRING)
    private Objective objective;

}

/*
@JsonIgnore 을 사용하여 순환 참조 문제 해결

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    @JsonIgnore
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnore
    private Member member;

    @Column(name = "portfolio_url", nullable = false)
    private String portfolioUrl;

    @Enumerated(EnumType.STRING)
    private Objective objective;
}

 */