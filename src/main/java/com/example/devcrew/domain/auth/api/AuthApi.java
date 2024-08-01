package com.example.devcrew.domain.auth.api;

import com.example.devcrew.domain.auth.api.dto.request.UpdateMemberRoleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth")
public interface AuthApi {

    @Operation(
            summary = "회원가입",
            description = "[ 기업 회원 / 일반 회원 ] 여부를 받아 권한이 GUEST -> USER 로 변경됩니다." +
                    "또한, 권한이 승격됨에 따라 Refresh Token 이 발급됩니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "회원가입이 성공적으로 완료되었습니다."
            )
    })
    void signUp(@RequestBody UpdateMemberRoleRequest request);
}
