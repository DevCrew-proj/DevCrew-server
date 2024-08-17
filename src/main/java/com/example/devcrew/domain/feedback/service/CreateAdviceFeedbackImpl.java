package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.AdviceFeedbackFile;
import com.example.devcrew.domain.feedback.entity.AdviceFeedbackImage;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackFileRepository;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackImageRepository;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateAdviceFeedbackImpl {

    private final AdviceFeedbackRepository adviceFeedbackRepository;
    private final AdviceFeedbackFileRepository adviceFeedbackFileRepository;
    private final AdviceFeedbackImageRepository adviceFeedbackImageRepository;
    private final AuthService authService;


    @Transactional
    public AdviceFeedback createAdviceFeedback(CreateAdviceFeedbackRequestDTO request) {
        // Member 조회
        Member member = authService.getLoginUser();
        if (member == null) {
            throw new MemberNotFoundException();
        }

        // Feedback 생성
        AdviceFeedback adviceFeedback = AdviceFeedbackConverter.toAdviceFeedback(request, member);

        // Feedback 저장
        adviceFeedbackRepository.save(adviceFeedback);

        // 파일 저장
        request.getFileUrls().forEach(fileUrl -> {
            AdviceFeedbackFile file = AdviceFeedbackFile.builder()
                    .adviceFeedback(adviceFeedback)
                    .fileUrl(fileUrl)
                    .build();
            adviceFeedbackFileRepository.save(file);
        });

        // 이미지 저장
        request.getImageUrls().forEach(imageUrl -> {
            AdviceFeedbackImage image = AdviceFeedbackImage.builder()
                    .adviceFeedback(adviceFeedback)
                    .imageUrl(imageUrl)
                    .build();
            adviceFeedbackImageRepository.save(image);
        });

        return adviceFeedback;
    }

}
