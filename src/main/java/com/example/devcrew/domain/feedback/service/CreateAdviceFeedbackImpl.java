package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateAdviceFeedbackImpl {

    private final AdviceFeedbackRepository adviceFeedbackRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;


    @Transactional
    public AdviceFeedback createAdviceFeedback(CreateAdviceFeedbackRequestDTO request) {
        // Member 조회
        Member member = authService.getLoginUser();

        // Feedback 생성
        AdviceFeedback adviceFeedback = AdviceFeedbackConverter.toAdviceFeedback(request, member);

        // Feedback 저장
        return adviceFeedbackRepository.save(adviceFeedback);
    }

}
