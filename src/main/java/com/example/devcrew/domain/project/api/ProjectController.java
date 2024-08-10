package com.example.devcrew.domain.project.api;


import com.example.devcrew.domain.project.dto.request.PostProjectRequest;
import com.example.devcrew.domain.project.dto.response.GetOneProjectResponse;
import com.example.devcrew.domain.project.dto.response.GetProjectsListResponse;
import com.example.devcrew.domain.project.dto.response.PostProjectResponse;
import com.example.devcrew.domain.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/projects")
@Tag(name = "project-controller")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "참여 프로젝트 업로드")
    @PostMapping()
    public ResponseEntity<PostProjectResponse> postProject(@RequestBody @Valid PostProjectRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.postProject(request));
    }

    @Operation(summary = "참여 프로젝트들 조회")
    @GetMapping()
    public ResponseEntity<GetProjectsListResponse> getProjects(@RequestParam(defaultValue = "1") int page,
                                                               @RequestParam(defaultValue = "9") int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(projectService.getProjects(pageable));
    }


    @Operation(summary = "개별 프로젝트 조회")
    @GetMapping("/{projectId}")
    public ResponseEntity<GetOneProjectResponse> getOneProject(@PathVariable("projectId")Long projectId){
        return ResponseEntity.ok(projectService.getOneProject(projectId));
    }

}
