package com.example.devcrew.domain.member.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Embeddable
@Getter
public class NormalMember {
    private String highSchool;
    private String college;
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private SchoolStatus highSchoolStatus;
    @Enumerated(EnumType.STRING)
    private SchoolStatus collegeStatus;




}