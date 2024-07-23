package com.example.devcrew.global.oauth2.handler;

import com.example.devcrew.domain.member.entity.Role;
import com.example.devcrew.global.jwt.service.JwtService;
import com.example.devcrew.global.oauth2.CustomOAuth2User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login succeed.");
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        if(oAuth2User.getRole() == Role.GUEST) {
            String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
            response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
            response.sendRedirect("/social-login?exist=false&Authorization=" + accessToken);

            jwtService.sendAccessAndRefreshToken(response, accessToken, null);
        } else {
            String redirect = loginSuccess(response, oAuth2User);
            response.sendRedirect(redirect);
        }
    }

    private String loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        log.info("회원가입에 성공하였습니다. refresh token 을 생성합니다.");

        String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
        String refreshToken = jwtService.createRefreshToken();
        response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
        response.addHeader(jwtService.getRefreshHeader(), "Bearer " + refreshToken);

        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);
        jwtService.updateRefreshToken(oAuth2User.getEmail(), refreshToken);
        return "/social-login?exist=true&Authorization=" + accessToken + "&Authorization-Refresh=" + refreshToken;
    }
}

