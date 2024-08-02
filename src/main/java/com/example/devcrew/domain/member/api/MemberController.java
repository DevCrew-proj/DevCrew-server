package com.example.devcrew.domain.member.api;

import com.example.devcrew.domain.member.service.MemberService;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.member.dto.response.GetMemberProfileResponse;
import com.example.devcrew.domain.member.dto.response.PostMemberProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.example.devcrew.domain.member.dto.request.UpdateCompanyMemberSignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup-company")
    public void registerDetailCompanyMember(
            @RequestBody UpdateCompanyMemberSignUpRequest request) {
        memberService.registerDetailCompanyMember(request);
    }

    @Transactional
    @Operation(summary = "자기 소개 작성")
    @PostMapping("/profile")
    PostMemberProfileResponse postMemberProfile(@RequestBody @Valid PostMemberProfileRequest request){
        return memberService.postMemberProfile(request);
    }

    @Operation(summary = "자기 소개 조회")
    @GetMapping("/mypage")
    GetMemberProfileResponse getMemberProfile(){
        return memberService.getMemberProfile();
    }

}
