package com.example.devcrew.domain.contest.entity;

import com.example.devcrew.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Contest extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String posterUrl;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 10)
    private String organization;

    @Column(length = 20)
    private String participantTarget;

    @Column(length = 20)
    private String award;

    private String homepageUrl;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private Sector sector;

    @Column(length = 20)
    private String benefits;

    @Column(length = 20)
    private String plusBenefits;

    @Lob
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "companyMember_id")
//    private CompanyMember companyMember;
//
//    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
//    private List<Team> teamList = new ArrayList<>();
}
