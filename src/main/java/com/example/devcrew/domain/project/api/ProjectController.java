package com.example.devcrew.domain.project.api;


import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.project.dto.request.PostProjectRequest;
import com.example.devcrew.domain.project.dto.response.GetOneProjectResponse;
import com.example.devcrew.domain.project.dto.response.GetProjectsListResponse;
import com.example.devcrew.domain.project.dto.response.PostProjectResponse;
import com.example.devcrew.domain.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "[포트폴리오]")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "참여 프로젝트 업로드")
    @PostMapping("/projects")
    PostProjectResponse postProject(@RequestBody @Valid PostProjectRequest request){
        return projectService.postProject(request);
    }

    @Operation(summary = "참여 프로젝트들 조회")
    @GetMapping("/projects")
    GetProjectsListResponse getProjects(){
        return projectService.getProjects();
    }


    @Operation(summary = "개별 프로젝트 조회")
    @GetMapping("/project/{projectId}")
    GetOneProjectResponse getOneProject(@PathVariable("projectId")Long projectId){
        return projectService.getOneProject(projectId);
    }
}
