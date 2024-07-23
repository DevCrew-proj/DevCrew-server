package com.example.devcrew.domain.member.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class NormalMember {


    private String highSchool;
    private String college;
    private String introduction;


    private Gender gender;
    private SchoolStatus highSchoolStatus;

    private SchoolStatus collegeStatus;




}