package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.repository.FeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateCodeFeedbackImpl implements CreateCodeFeedback {

    private final FeedbackRepository feedbackRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;

    @Override
    @Transactional
    public Feedback createCodeFeedback(CreateCodeFeedbackRequestDTO request) {
       // 멤버 조회
        Member member = authService.getLoginUser();

        Feedback codeFeedback = CodeFeedbackConverter.toCodeFeedback(request, member);
        codeFeedback.setMembertoFeedback(memberRepository.findById(member.getId()).get());

        return feedbackRepository.save(codeFeedback);
    }
}
