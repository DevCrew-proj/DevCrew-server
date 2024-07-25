package com.example.devcrew.domain.project.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    @GetMapping("/info")
    public ResponseEntity<?> getInfo(){
        String responseData="it is ok";
        return ResponseEntity.ok(responseData);
    }
}
