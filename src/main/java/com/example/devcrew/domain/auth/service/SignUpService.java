package com.example.devcrew.domain.auth.service;

import com.example.devcrew.domain.member.dto.request.UpdateMemberSignUpRequest;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.global.jwt.refresh.service.RefreshTokenService;
import com.example.devcrew.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final HttpServletResponse response;
    private final MemberRepository memberRepository;

    @Transactional
    public boolean signUp(UpdateMemberSignUpRequest request) {
        if (memberRepository.existsByNickname(request.getNickname())) {
            return false;
        }
        Member member = authService.getLoginUser();
        member.signUp(request);
        String refreshToken = jwtService.createRefreshToken();
        jwtService.setRefreshTokenHeader(response, refreshToken);
        refreshTokenService.updateToken(member.getEmail(), refreshToken);
        return true;
    }
}
