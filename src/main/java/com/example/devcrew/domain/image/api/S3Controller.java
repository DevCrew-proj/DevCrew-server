package com.example.devcrew.domain.image.api;

import com.example.devcrew.domain.image.dto.CreateProfileImageResponse;
import com.example.devcrew.domain.image.service.S3Service;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;
    private final MemberRepository memberRepository;


    @Operation(summary = "일반회원 - 자기소개 이미지 등록 URL 생성")
    @PostMapping("/profile/image")
    public CreateProfileImageResponse createProfileImage( @RequestParam String fileExtension){
        Member member=memberRepository.findById(1L)
                .orElseThrow(MemberNotFoundException::new);
        return s3Service.generatePresignedUrl("member",member.getId(),fileExtension);

    }

    @Operation(summary = "일반회원 - 참여 프로젝트 이미지")
    @PostMapping("/project/image")
    public CreateProfileImageResponse createProjectImage( @RequestParam String fileExtension){
        return s3Service.generatePresignedUrl("project",1L,fileExtension);

    }



}
