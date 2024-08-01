package com.example.devcrew.domain.member.api;

import com.example.devcrew.domain.member.dto.request.UpdateCompanyMemberSignUpRequest;
import com.example.devcrew.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
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
}
