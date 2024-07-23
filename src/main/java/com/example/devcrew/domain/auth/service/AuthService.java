package com.example.devcrew.domain.auth.service;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.global.jwt.service.JwtService;
import com.example.devcrew.global.query.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.devcrew.domain.member.exception.MemberNotFoundException;

@Slf4j
@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;


    @Value("${oauth.kakao.admin-key}")
    private String kakaoAdminKey;

    @Value("${oauth.kakao.withdraw-uri}")
    private String kakaoWithdrawUri;

    public Member getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(MemberNotFoundException::new);
    }
}
