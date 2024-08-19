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
    private Long totalElements;
    private int totalPages;


    public static GetProjectsListResponse of(Member member,List<GetOneProjectResponse> projects,Long totalElements,int totalPages){
        return GetProjectsListResponse.builder()
                .memberId(member.getId())
                .projectList((projects))
                .totalElements(totalElements)
                .totalPages(totalPages)
                .build();
    }


}
