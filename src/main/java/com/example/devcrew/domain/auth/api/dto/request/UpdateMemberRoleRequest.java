package com.example.devcrew.domain.auth.api.dto.request;

import com.example.devcrew.domain.member.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateMemberRoleRequest {
    Role role;
}
