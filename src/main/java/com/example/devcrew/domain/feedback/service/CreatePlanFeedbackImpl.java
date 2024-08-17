package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.PlanFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreatePlanFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.*;
import com.example.devcrew.domain.feedback.repository.PlanFeedbackFileRepository;
import com.example.devcrew.domain.feedback.repository.PlanFeedbackImageRepository;
import com.example.devcrew.domain.feedback.repository.PlanFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreatePlanFeedbackImpl {
    private final PlanFeedbackRepository planFeedbackRepository;
    private final PlanFeedbackFileRepository planFeedbackFileRepository;
    private final PlanFeedbackImageRepository planFeedbackImageRepository;
    private final AuthService authService;

    @Transactional
    public PlanFeedback createPlanFeedback(CreatePlanFeedbackRequestDTO request) {
        Member member = authService.getLoginUser();

        if (member == null) {
            throw new MemberNotFoundException();
        }

        PlanFeedback planFeedback = PlanFeedbackConverter.toPlanFeedback(request, member);

        planFeedbackRepository.save(planFeedback);

        // 파일 저장
        request.getFileUrls().forEach(fileUrl -> {
            PlanFeedbackFile file = PlanFeedbackFile.builder()
                    .planFeedback(planFeedback)
                    .fileUrl(fileUrl)
                    .build();
            planFeedbackFileRepository.save(file);
        });

        // 이미지 저장
        request.getImageUrls().forEach(imageUrl -> {
            PlanFeedbackImage image = PlanFeedbackImage.builder()
                    .planFeedback(planFeedback)
                    .imageUrl(imageUrl)
                    .build();
            planFeedbackImageRepository.save(image);
        });

        return planFeedback;
    }
}
