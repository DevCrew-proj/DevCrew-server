package com.example.devcrew.domain.member.entity;

import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
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
    private HighSchoolStatus highSchoolStatus;

    @Enumerated(EnumType.STRING)
    private CollegeStatus collegeStatus;

    public void updateNormalMemberProfile(PostMemberProfileRequest request){
        this.highSchool=request.getHighSchool();
        this.college=request.getCollege();
        this.introduction=request.getIntroduction();
        this.highSchoolStatus=request.getHighSchoolStatus();
        this.college=request.getCollege();
    }



}