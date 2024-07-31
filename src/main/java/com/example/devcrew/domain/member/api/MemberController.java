package com.example.devcrew.domain.member.api;

import com.example.devcrew.domain.member.service.MemberService;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.member.dto.response.GetMemberProfileResponse;
import com.example.devcrew.domain.member.dto.response.PostMemberProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/profile")
@Tag(name="[포트폴리오]")
public class MemberController {
    private final MemberService memberService;

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
