package com.example.devcrew.domain.member.dto.response;

import com.example.devcrew.domain.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMemberRoleResponse {
    private Role role;
}
