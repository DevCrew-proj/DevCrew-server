package com.example.devcrew.domain.member.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.member.dto.request.UpdateCompanyMemberSignUpRequest;
import com.example.devcrew.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;

    @Transactional
    public void registerDetailCompanyMember(UpdateCompanyMemberSignUpRequest request) {
        final Member member = authService.getLoginUser();
        member.updateCompanyMember(request.getCompanyMemberEntity());
    }
}
