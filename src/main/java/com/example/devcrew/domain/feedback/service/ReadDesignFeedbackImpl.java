package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.comment.repository.DesignCommentRepository;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.DesignFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import com.example.devcrew.domain.feedback.exception.FeedbackNotFoundException;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadDesignFeedbackImpl {
    private final DesignFeedbackRepository designFeedbackRepository;
    private final DesignCommentRepository designCommentRepository;

    @Transactional
    public ReadDesignFeedbackResponseDTO readDesignFeedback(Long designFeedbackId) {
        DesignFeedback designFeedback = designFeedbackRepository.findById(designFeedbackId)
                .orElseThrow(FeedbackNotFoundException::new);

        long commentCount = designCommentRepository.countByDesignFeedback_Id(designFeedbackId);

        return DesignFeedbackConverter.toReadDesignFeedbackResponseDTO(designFeedback, commentCount);
    }

    @Transactional
    public ReadDesignFeedbackListResponseDTO readDesignFeedbackList(int page) {
        PageRequest pageRequest = PageRequest.of(page, 4, Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<DesignFeedback> designFeedbackPage = designFeedbackRepository.findAll(pageRequest);

        return DesignFeedbackConverter.toReadDesignFeedbackListResponseDTO(designFeedbackPage, designCommentRepository);
    }
}
