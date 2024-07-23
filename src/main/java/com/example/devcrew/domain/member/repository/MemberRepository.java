package com.example.devcrew.domain.member.repository;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.entity.Role;
import com.example.devcrew.domain.member.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findBySocialTypeAndOauthId(SocialType socialType, String oauthId);

    boolean existsByNicknameAndRole(String nickname, Role role);
    boolean existsByNickname(String nickname);
}