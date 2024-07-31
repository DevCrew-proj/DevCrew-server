package com.example.devcrew.domain.member.dto.response;


import com.example.devcrew.domain.member.entity.CollegeStatus;
import com.example.devcrew.domain.member.entity.Gender;
import com.example.devcrew.domain.member.entity.HighSchoolStatus;
import com.example.devcrew.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMemberProfileResponse {

    private Long id;

    private String imageUrl;

    private String phoneNumber;

    private String name;

    private String email;


    private String highSchool;
    private HighSchoolStatus highSchoolStatus;

    private String college;
    private CollegeStatus collegeStatus;

    private String introduction;

    public static GetMemberProfileResponse from(Member member){
        return  GetMemberProfileResponse.builder()
                .id(member.getId())
                .imageUrl(member.getImageUrl())
                .phoneNumber(member.getPhoneNumber())
                .name(member.getName())
                .email(member.getEmail())
                .highSchool(member.getNormalMember().getHighSchool())
                .highSchoolStatus(member.getNormalMember().getHighSchoolStatus())
                .college(member.getNormalMember().getCollege())
                .collegeStatus(member.getNormalMember().getCollegeStatus())
                .introduction(member.getNormalMember().getIntroduction())
                .build();
    }

}
