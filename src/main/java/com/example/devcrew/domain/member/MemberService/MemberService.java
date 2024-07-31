package com.example.devcrew.domain.member.MemberService;


import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.member.dto.request.PostMemberProfileRequest;
import com.example.devcrew.domain.member.dto.response.PostMemberProfileResponse;
import com.example.devcrew.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final AuthService authService;

    @Transactional
    public PostMemberProfileResponse postMemberProfile(PostMemberProfileRequest request){
        Member member = authService.getLoginUser();
        member.updateMemberProfile(request);
        return PostMemberProfileResponse.from(member);

    }


}
