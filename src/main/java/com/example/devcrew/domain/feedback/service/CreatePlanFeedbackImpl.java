package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.PlanFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreatePlanFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.PlanFeedback;
import com.example.devcrew.domain.feedback.repository.PlanFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreatePlanFeedbackImpl {
    private final PlanFeedbackRepository planFeedbackRepository;
    private final AuthService authService;

    @Transactional
    public PlanFeedback createPlanFeedback(CreatePlanFeedbackRequestDTO request) {
        Member member = authService.getLoginUser();

        PlanFeedback planFeedback = PlanFeedbackConverter.toPlanFeedback(request, member);

        return planFeedbackRepository.save(planFeedback);
    }
}
