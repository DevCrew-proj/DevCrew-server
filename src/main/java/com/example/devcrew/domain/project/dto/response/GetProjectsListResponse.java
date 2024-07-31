package com.example.devcrew.domain.project.dto.response;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.project.entity.Project;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetProjectsListResponse {
    private Long memberId;
    private List<GetOneProjectResponse> projectList;

    public static GetProjectsListResponse of(Member member,List<GetOneProjectResponse> projects){
        return GetProjectsListResponse.builder()
                .memberId(member.getId())
                .projectList((projects))
                .build();
    }


}
