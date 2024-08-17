package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.entity.*;
import com.example.devcrew.domain.feedback.repository.CodeFeedbackFileRepository;
import com.example.devcrew.domain.feedback.repository.CodeFeedbackImageRepository;
import com.example.devcrew.domain.feedback.repository.CodeFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateCodeFeedbackImpl {

    private final CodeFeedbackRepository codeFeedbackRepository;
    private final CodeFeedbackImageRepository codeFeedbackImageRepository;
    private final CodeFeedbackFileRepository codeFeedbackFileRepository;
    private final AuthService authService;

    @Transactional
    public CodeFeedback createCodeFeedback(CreateCodeFeedbackRequestDTO request) {
       // 멤버 조회
        Member member = authService.getLoginUser();

        if (member == null) {
            throw new MemberNotFoundException();
        }

        CodeFeedback codeFeedback = CodeFeedbackConverter.toCodeFeedback(request, member);

        codeFeedbackRepository.save(codeFeedback);

        // 파일 저장
        request.getFileUrls().forEach(fileUrl -> {
            CodeFeedbackFile file = CodeFeedbackFile.builder()
                    .codeFeedback(codeFeedback)
                    .fileUrl(fileUrl)
                    .build();
            codeFeedbackFileRepository.save(file);
        });

        // 이미지 저장
        request.getImageUrls().forEach(imageUrl -> {
            CodeFeedbackImage image = CodeFeedbackImage.builder()
                    .codeFeedback(codeFeedback)
                    .imageUrl(imageUrl)
                    .build();
            codeFeedbackImageRepository.save(image);
        });

        return codeFeedback;
    }
}
