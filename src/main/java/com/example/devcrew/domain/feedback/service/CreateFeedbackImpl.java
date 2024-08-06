package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.FeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateFeedbackRequestDTO;
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
public class CreateFeedbackImpl {

    private final FeedbackRepository feedbackRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;

    @Transactional
    public Feedback createFeedback(CreateFeedbackRequestDTO request) {
        Member member = authService.getLoginUser();

        Feedback planFeedback = FeedbackConverter.toFeedback(request, member);
        planFeedback.setMembertoFeedback(memberRepository.findById(member.getId()).get());

        return feedbackRepository.save(planFeedback);
    }

}
