package com.example.devcrew.domain.auth.api;

import com.example.devcrew.domain.auth.service.SignUpService;
import com.example.devcrew.domain.member.dto.request.UpdateMemberSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
    private final SignUpService signUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/social-login")
    public boolean signUp(@RequestBody UpdateMemberSignUpRequest request) {
        return signUpService.signUp(request);
    }

}