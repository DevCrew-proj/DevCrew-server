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
    private final AuthService authService;


    @Override
    @Transactional
    public Contest createContestsByMember(CreateContestRequestDTO request) {
        Member member = authService.getLoginUser();

        if (member == null) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND_ERROR);
        }

        Contest newContest = ContestConverter.toContest(request, member);
        return contestRepository.save(newContest);
    }
}
