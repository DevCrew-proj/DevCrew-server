package com.example.devcrew.domain.member.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.member.dto.request.UpdateCompanyMemberSignUpRequest;
import com.example.devcrew.domain.member.dto.response.GetMemberProfileResponse;
import com.example.devcrew.domain.member.dto.response.PostMemberProfileResponse;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;
    private final MemberRepository memberRepository;

    @Transactional
    public void registerDetailCompanyMember(UpdateCompanyMemberSignUpRequest request) {
        final Member member = authService.getLoginUser();

        member.updateCompanyMember(request.getCompanyMemberEntity());
    }

    @Transactional
    public PostMemberProfileResponse postMemberProfile(PostMemberProfileRequest request){

        Member member = authService.getLoginUser();

        member.updateMemberProfile(request);
        return PostMemberProfileResponse.from(member);

    }

    public GetMemberProfileResponse getMemberProfile(){

        Member member = authService.getLoginUser();

        return GetMemberProfileResponse.from(member);

    }
}

