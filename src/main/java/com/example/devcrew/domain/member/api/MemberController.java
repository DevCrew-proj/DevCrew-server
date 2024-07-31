package com.example.devcrew.domain.member.api;

import com.example.devcrew.domain.member.MemberService.MemberService;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.member.dto.response.PostMemberProfileResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
@Tag(name="[자기소개]")
public class MemberController {
    private final MemberService memberService;

    @Transactional
    @PostMapping
    PostMemberProfileResponse postMemberProfile(@RequestBody @Valid PostMemberProfileRequest request){
        return memberService.postMemberProfile(request);
    }



}
