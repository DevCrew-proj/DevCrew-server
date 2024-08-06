package com.example.devcrew.domain.project.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.domain.member.service.MemberService;
import com.example.devcrew.domain.project.dto.request.PostProjectRequest;
import com.example.devcrew.domain.project.dto.response.GetOneProjectResponse;
import com.example.devcrew.domain.project.dto.response.GetProjectsListResponse;
import com.example.devcrew.domain.project.dto.response.PostProjectResponse;
import com.example.devcrew.domain.project.entity.Project;
import com.example.devcrew.domain.project.exception.ProjectNotFoundException;
import com.example.devcrew.domain.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;
    private final AuthService authService;

    @Transactional
    public PostProjectResponse postProject(PostProjectRequest request){

        Member member = authService.getLoginUser();

        Project project=Project.of(member,request);
        projectRepository.save(project);

        return PostProjectResponse.from(project);

    }


    //모든 프로젝트 반환
    public GetProjectsListResponse getProjects(){

        Member member = authService.getLoginUser();

        List<Project> projects=projectRepository.findByMember(member);


        List<GetOneProjectResponse> projectList= projects.stream()
                .map(project -> GetOneProjectResponse.from(project))
                .collect(Collectors.toList());

        return GetProjectsListResponse.of(member,projectList);

    }


    //개별 프로젝트 반환
    public GetOneProjectResponse getOneProject(Long projectId){
        Project project=projectRepository.findById(projectId)
                .orElseThrow(()-> new ProjectNotFoundException());
        return GetOneProjectResponse.from(project);
    }

}
