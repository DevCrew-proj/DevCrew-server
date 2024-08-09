package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.feedback.dto.request.CreateDesignFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreatePlanFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.CreateDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.CreatePlanFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.ReadPlanFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.ReadPlanFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import com.example.devcrew.domain.feedback.entity.PlanFeedback;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanFeedbackConverter {
    public static PlanFeedback toPlanFeedback(CreatePlanFeedbackRequestDTO request, Member member){
        return PlanFeedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(member)
                .build();
    }

    public static CreatePlanFeedbackResponseDTO toCreatePlanFeedbackResponseDTO(PlanFeedback planFeedback){
        return CreatePlanFeedbackResponseDTO.builder()
                .id(planFeedback.getId())
                .memberId(planFeedback.getMember().getId())
                .createdAt(planFeedback.getCreatedAt())
                .updatedAt(planFeedback.getUpdatedAt())
                .build();
    }

    public static ReadPlanFeedbackResponseDTO toReadPlanFeedbackResponseDTO(PlanFeedback planFeedback){
        return ReadPlanFeedbackResponseDTO.builder()
                .id(planFeedback.getId())
                .title(planFeedback.getTitle())
                .content(planFeedback.getContent())
                .memberName(planFeedback.getMember().getNickname())
                .build();
    }

    public static ReadPlanFeedbackListResponseDTO toReadPlanFeedbackListResponseDTO(Page<PlanFeedback> feedbackPage){
        List<ReadPlanFeedbackResponseDTO> planFeedbackList = feedbackPage.getContent().stream()
                .map(PlanFeedbackConverter::toReadPlanFeedbackResponseDTO)
                .collect(Collectors.toList());

        return ReadPlanFeedbackListResponseDTO.builder()
                .planFeedbackList(planFeedbackList)

                .totalPages(feedbackPage.getTotalPages())
                .build();
    }
}
