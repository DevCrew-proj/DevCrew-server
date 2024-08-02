package com.example.devcrew.domain.member.dto.response;


import com.example.devcrew.domain.member.entity.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostMemberProfileResponse {
    private Long id;

    private String name;

    private String email;

    private String imageUrl;

    private String phoneNumber;

    private String highSchool;
    private HighSchoolStatus highSchoolStatus;

    private String college;
    private CollegeStatus collegeStatus;

    private String introduction;

    private Gender gender;

    public static PostMemberProfileResponse from(Member member){
        return  PostMemberProfileResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .imageUrl(member.getImageUrl())
                .phoneNumber(member.getNormalMember().getPhoneNumber())
                .highSchool(member.getNormalMember().getHighSchool())
                .highSchoolStatus(member.getNormalMember().getHighSchoolStatus())
                .college(member.getNormalMember().getCollege())
                .collegeStatus(member.getNormalMember().getCollegeStatus())
                .introduction(member.getNormalMember().getIntroduction())
                .gender(member.getNormalMember().getGender())
                .build();
    }

}
