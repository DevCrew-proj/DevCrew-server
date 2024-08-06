package com.example.devcrew.domain.image.api;

import com.example.devcrew.domain.image.dto.GetPresignedUrlResponse;
import com.example.devcrew.domain.image.service.S3Service;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="이미지 등록")
public class S3Controller {

    private final S3Service s3Service;

    @Operation(summary = "자기소개 이미지 presignedURL 발급받기")
    @PostMapping("/image/member")
    public GetPresignedUrlResponse getMemberImagePresignedUrl(@RequestParam String fileExtension){
        return s3Service.getPresignedUrl("member",fileExtension);
    }


    @Operation(summary = "일반회원 참여 프로젝트 이미지 presignedUrl 발급받기")
    @PostMapping("/images/project")
    public List<GetPresignedUrlResponse> getProjectImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("member", fileExtension));
        }

        return presignedUrls;
    }

    @Operation(summary = "기업 공모전 등록 프로젝트 이미지 presignedUrl 발급받기")
    @PostMapping("/images/company")
    public List<GetPresignedUrlResponse> getCompanyImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("company", fileExtension));
        }
        return presignedUrls;
    }

    @Operation(summary = "팀매칭 서비스 기획안 이미지 presignedUrl 발급받기")
    @PostMapping("/images/team")
    public List<GetPresignedUrlResponse> getTeamMatchingImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("team", fileExtension));
        }
        return presignedUrls;
    }


    @Operation(summary = "현직자 조언 등록 이미지 presignedUrl 발급받기")
    @PostMapping("/images/advice")
    public List<GetPresignedUrlResponse> getAdviceImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("advice", fileExtension));
        }
        return presignedUrls;
    }

    @Operation(summary = "기획 피드백 등록 이미지 presignedUrl 발급받기")
    @PostMapping("/images/plan")
    public List<GetPresignedUrlResponse> getPlanImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("plan", fileExtension));
        }
        return presignedUrls;
    }

    @Operation(summary = "디자인 피드백 등록 이미지 presignedUrl 발급받기")
    @PostMapping("/images/design")
    public List<GetPresignedUrlResponse> getDesignImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("design", fileExtension));
        }
        return presignedUrls;
    }

    @Operation(summary = "코드 리뷰 등록 이미지 presignedUrl 발급받기")
    @PostMapping("/images/codeReview")
    public List<GetPresignedUrlResponse> getCodeReviewImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("codeReview", fileExtension));
        }
        return presignedUrls;
    }










}
