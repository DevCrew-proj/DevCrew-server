package com.example.devcrew.domain.feedback.service;

import com.example.devcrew.domain.feedback.converter.PlanFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.ReadPlanFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.ReadPlanFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.PlanFeedback;
import com.example.devcrew.domain.feedback.repository.PlanFeedbackRepository;
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
public class ReadPlanFeedbackImpl {
    private final PlanFeedbackRepository planFeedbackRepository;

    @Transactional
    public ReadPlanFeedbackResponseDTO readPlanFeedback(Long planFeedbackId) {
        PlanFeedback planFeedback = planFeedbackRepository.findById(planFeedbackId)
                .orElseThrow(() -> new RuntimeException("PlanFeedback not found"));

        return PlanFeedbackConverter.toReadPlanFeedbackResponseDTO(planFeedback);
    }

    @Transactional
    public ReadPlanFeedbackListResponseDTO readPlanFeedbackList(int page) {
        PageRequest pageRequest = PageRequest.of(page, 4);

        Page<PlanFeedback> planFeedbackPage = planFeedbackRepository.findAll(pageRequest);

        List<ReadPlanFeedbackResponseDTO> planFeedbackList = planFeedbackPage.getContent().stream()
                .map(PlanFeedbackConverter::toReadPlanFeedbackResponseDTO)
                .collect(Collectors.toList());

        return new ReadPlanFeedbackListResponseDTO(planFeedbackList, planFeedbackPage.getTotalPages());
    }
}