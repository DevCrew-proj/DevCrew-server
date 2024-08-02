package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.FeedbackImageUuid;
import com.example.devcrew.domain.feedback.repository.FeedbackImageUuidRepository;
import com.example.devcrew.domain.feedback.repository.FeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateAdviceFeedbackImpl implements CreateAdviceFeedback {

    private final FeedbackRepository feedbackRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;


    @Override
    @Transactional
    public Feedback createAdviceFeedback(CreateAdviceFeedbackRequestDTO request) {
        // Member 조회
        Member member = authService.getLoginUser();

        // Feedback 생성
        Feedback adviceFeedback = AdviceFeedbackConverter.toadviceFeedback(request, member);
        adviceFeedback.setMember(memberRepository.findById(member.getId()).get());

        // Feedback 저장
        return feedbackRepository.save(adviceFeedback);
    }

}
