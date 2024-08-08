package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.DesignFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateDesignFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateDesignFeedbackImpl {
    private final DesignFeedbackRepository designFeedbackRepository;
    private final AuthService authService;

    @Transactional
    public DesignFeedback createDesignFeedback(CreateDesignFeedbackRequestDTO request) {
        // 멤버 조회
        Member member = authService.getLoginUser();

        DesignFeedback designFeedback = DesignFeedbackConverter.toDesignFeedback(request, member);

        return designFeedbackRepository.save(designFeedback);
    }
}
