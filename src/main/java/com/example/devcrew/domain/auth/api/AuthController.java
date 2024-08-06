package com.example.devcrew.domain.auth.api;

import com.example.devcrew.domain.auth.api.dto.request.UpdateMemberRoleRequest;
import com.example.devcrew.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
    private final SignUpService signUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/social-login")
    @Override
    public void signUp(@RequestBody UpdateMemberRoleRequest request) {
        signUpService.signUp(request);
    }
}