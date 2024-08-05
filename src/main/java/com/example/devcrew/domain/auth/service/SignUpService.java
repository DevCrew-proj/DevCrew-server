package com.example.devcrew.domain.auth.service;

import com.example.devcrew.domain.auth.api.dto.request.UpdateMemberRoleRequest;
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

    @Transactional
    public void signUp(UpdateMemberRoleRequest request) {
        Member member = authService.getLoginUser();
        member.updateRole(request.getRole());
        String refreshToken = jwtService.createRefreshToken();
        jwtService.setRefreshTokenHeader(response, refreshToken);
        refreshTokenService.updateToken(member.getEmail(), refreshToken);
    }
}
