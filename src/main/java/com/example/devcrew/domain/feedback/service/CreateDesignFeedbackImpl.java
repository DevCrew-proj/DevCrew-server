package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.DesignFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateDesignFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.*;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackFileRepository;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackImageRepository;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateDesignFeedbackImpl {
    private final DesignFeedbackRepository designFeedbackRepository;
    private final DesignFeedbackFileRepository designFeedbackFileRepository;
    private final DesignFeedbackImageRepository designFeedbackImageRepository;
    private final AuthService authService;

    @Transactional
    public DesignFeedback createDesignFeedback(CreateDesignFeedbackRequestDTO request) {
        // 멤버 조회
        Member member = authService.getLoginUser();

        if (member == null) {
            throw new MemberNotFoundException();
        }

        DesignFeedback designFeedback = DesignFeedbackConverter.toDesignFeedback(request, member);

        designFeedbackRepository.save(designFeedback);

        // 파일 저장
        request.getFileUrls().forEach(fileUrl -> {
            DesignFeedbackFile file = DesignFeedbackFile.builder()
                    .designFeedback(designFeedback)
                    .fileUrl(fileUrl)
                    .build();
            designFeedbackFileRepository.save(file);
        });

        // 이미지 저장
        request.getImageUrls().forEach(imageUrl -> {
            DesignFeedbackImage image = DesignFeedbackImage.builder()
                    .designFeedback(designFeedback)
                    .imageUrl(imageUrl)
                    .build();
            designFeedbackImageRepository.save(image);
        });

        return designFeedback;
    }
}
