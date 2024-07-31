package com.example.devcrew.domain.member.MemberService;


import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.member.dto.response.GetMemberProfileResponse;
import com.example.devcrew.domain.member.dto.response.PostMemberProfileResponse;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final AuthService authService;
    private final MemberRepository memberRepository;

    @Transactional
    public PostMemberProfileResponse postMemberProfile(PostMemberProfileRequest request){

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberNotFoundException());

        member.updateMemberProfile(request);
        return PostMemberProfileResponse.from(member);

    }

    public GetMemberProfileResponse getMemberProfile(){
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberNotFoundException());
        return GetMemberProfileResponse.from(member);

    }




}
