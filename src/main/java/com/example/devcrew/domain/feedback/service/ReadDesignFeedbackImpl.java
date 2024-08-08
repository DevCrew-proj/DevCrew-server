package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.DesignFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadDesignFeedbackImpl {
    private final DesignFeedbackRepository designFeedbackRepository;

    @Transactional
    public ReadDesignFeedbackResponseDTO readDesignFeedback(Long designFeedbackId) {
        DesignFeedback designFeedback = designFeedbackRepository.findById(designFeedbackId)
                .orElseThrow(() -> new RuntimeException("DesignFeedback not found"));

        return DesignFeedbackConverter.toReadDesignFeedbackResponseDTO(designFeedback);
    }

    @Transactional
    public ReadDesignFeedbackListResponseDTO readDesignFeedbackList(int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);

        Page<DesignFeedback> designFeedbackPage = designFeedbackRepository.findAll(pageRequest);

        List<ReadDesignFeedbackResponseDTO> designFeedbackList = designFeedbackPage.getContent().stream()
                .map(DesignFeedbackConverter::toReadDesignFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadDesignFeedbackListResponseDTO(designFeedbackList, designFeedbackPage.getTotalPages());
    }
}
