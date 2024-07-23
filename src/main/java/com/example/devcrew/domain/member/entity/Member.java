package com.example.devcrew.domain.member.entity;

import com.example.devcrew.domain.member.dto.request.UpdateMemberSignUpRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;
    private String password;
    private String name;

    private String nickname;
    private String email;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void signUp(UpdateMemberSignUpRequest dto) {
        this.nickname = dto.getNickname();
        this.role = Role.USER;
    }
}

