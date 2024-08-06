package com.example.devcrew.domain.contest.service;

import com.example.devcrew.domain.contest.converter.ContestConverter;
import com.example.devcrew.domain.contest.dto.request.CreateContestRequestDTO;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.repository.ContestRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.devcrew.domain.auth.service.AuthService;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContestCommandServiceImpl implements ContestCommandService {
    private final ContestRepository contestRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService; // AuthService 주입


//    @Override
//    @Transactional
//    public Contest createContestsByMember(CreateContestRequestDTO request) {
//        Member member = memberRepository.findById(request.getMemberId())
//                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND_ERROR));
//
//        Contest newContest = ContestConverter.toContest(request, member);
//        return contestRepository.save(newContest);
//    }
    @Override
    @Transactional
    public Contest createContestsByMember(CreateContestRequestDTO request) {
        Member member = authService.getLoginUser(); // 현재 로그인한 사용자 정보를 가져옴

        if (member == null) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND_ERROR); // 로그인한 사용자가 없을 경우 예외 처리
        }

        Contest newContest = ContestConverter.toContest(request, member);
        return contestRepository.save(newContest);
    }
}

// http://localhost:8080/social-login?exist=false&Authorization=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBY2Nlc3NUb2tlbiIsImV4cCI6MTcyMzQ0NzQ2NSwiZW1haWwiOiJ0bWRybDc3NzdAZ21haWwuY29tIn0.rHxy09g_ELs3tmcrHlMk-byQqa9-UmS-xZ186U6r1IssSLZ69OyuOXddIrSmhtXOKKaX90mZVCWoEs6wesTR-w