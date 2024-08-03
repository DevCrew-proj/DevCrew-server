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
    private final MemberRepository memberRepository;

    @Operation(summary = "자기소개 이미지 presignedURL 발급받기")
    @PostMapping("/image/member")
    public GetPresignedUrlResponse getMemberImagePresignedUrl(@RequestParam String fileExtension){
        //memberId를 가져오는 코드
        Member member=memberRepository.findById(1L)
                .orElseThrow(MemberNotFoundException::new);
        return s3Service.getPresignedUrl("member",member.getId(),fileExtension);
    }


    @Operation(summary = "일반회원 참여 프로젝트 이미지 presignedUrl 발급받기")
    @PostMapping("/images/member")
    public List<GetPresignedUrlResponse> getProjectImagesPresignedUrls(@RequestParam List<String> fileExtensions) {

        //memberId를 가져오는 코드
        Member member=memberRepository.findById(1L)
                .orElseThrow(MemberNotFoundException::new);

        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();

        for (String fileExtension : fileExtensions) {
            presignedUrls.add(s3Service.getPresignedUrl("member",member.getId(), fileExtension));
        }
        return presignedUrls;
    }

//    @Operation(summary = "기업 공모전 등록 프로젝트 이미지 presignedUrl 발급받기")
//    @PostMapping("/images/company")
//    public List<GetPresignedUrlResponse> getCompanyImagesPresignedUrls(@RequestParam List<String> fileExtensions) {
//
//        //companyId를 가져오는 코드 추가
//
//
//        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();
//
//        for (String fileExtension : fileExtensions) {
//            presignedUrls.add(s3Service.getPresignedUrl("company",company.getId(), fileExtension));
//        }
//        return presignedUrls;
//    }
//
//    @Operation(summary = "팀매칭 서비스 기획안 이미지 presignedUrl 발급받기")
//    @PostMapping("/images/team")
//    public List<GetPresignedUrlResponse> getTeamMatchingImagesPresignedUrls(@RequestParam List<String> fileExtensions) {
//
//        //teamId를 가져오는 코드 추가
//
//        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();
//
//        for (String fileExtension : fileExtensions) {
//            presignedUrls.add(s3Service.getPresignedUrl("team",team.getId(), fileExtension));
//        }
//        return presignedUrls;
//    }
//
//
//    @Operation(summary = "팀매칭 서비스 기획안 이미지 presignedUrl 발급받기")
//    @PostMapping("/images/feedback")
//    public List<GetPresignedUrlResponse> getFeedbackImagesPresignedUrls(@RequestParam List<String> fileExtensions) {
//
//        //feedbackId를 가져오는 코드 추가
//
//        List<GetPresignedUrlResponse> presignedUrls = new ArrayList<>();
//
//        for (String fileExtension : fileExtensions) {
//            presignedUrls.add(s3Service.getPresignedUrl("feedback",feedback.getId(), fileExtension));
//        }
//        return presignedUrls;
//    }








}
