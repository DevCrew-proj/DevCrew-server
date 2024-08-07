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
import com.example.devcrew.domain.project.entity.ProjectImage;
import com.example.devcrew.domain.project.exception.ProjectNotFoundException;
import com.example.devcrew.domain.project.repository.ProjectImageRepository;
import com.example.devcrew.domain.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectImageRepository projectImageRepository;
    private final AuthService authService;

    @Transactional
    public PostProjectResponse postProject(PostProjectRequest request){

        Member member = authService.getLoginUser();

        Project project=Project.of(member,request);
        projectRepository.save(project);

        for (String imageUrl : request.getImages()) {
            projectImageRepository.save(ProjectImage.of(imageUrl,project));
        }

        return PostProjectResponse.of(project,request.getImages());
    }


    //모든 프로젝트 반환
    public GetProjectsListResponse getProjects(){

        Member member = authService.getLoginUser();

        List<Project> projects=projectRepository.findProjectsWithImagesByMember(member)
                .orElseThrow(()-> new ProjectNotFoundException());

        List<GetOneProjectResponse> projectList= projects.stream()
                .map(project -> {
                    List<String>images=project.getProjectImages().stream()
                            .map(ProjectImage::getImageUrl)
                            .collect(Collectors.toList());
                    return GetOneProjectResponse.of(project,images);
                })
                .collect(Collectors.toList());

        return GetProjectsListResponse.of(member,projectList);

    }


    //개별 프로젝트 반환
    public GetOneProjectResponse getOneProject(Long projectId){
        Project project=projectRepository.findRecruitWithImagesById(projectId)
                .orElseThrow(()-> new ProjectNotFoundException());

        List<String> images = project.getProjectImages().stream()
                .map(ProjectImage::getImageUrl)
                .collect(Collectors.toList());

        return GetOneProjectResponse.of(project,images);
    }

}
