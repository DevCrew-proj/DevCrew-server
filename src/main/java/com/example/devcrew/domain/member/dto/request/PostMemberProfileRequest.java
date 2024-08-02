package com.example.devcrew.domain.member.dto.request;


import com.example.devcrew.domain.member.entity.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostMemberProfileRequest {

    private String name;

    private String phoneNumber;

    private String introduction;

    private String highSchool;

    private String college;

    private Gender gender;

    private HighSchoolStatus highSchoolStatus;

    private CollegeStatus collegeStatus;
}
