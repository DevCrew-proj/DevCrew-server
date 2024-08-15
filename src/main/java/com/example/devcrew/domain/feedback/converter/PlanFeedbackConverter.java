package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.comment.repository.PlanCommentRepository;
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

    public static ReadPlanFeedbackResponseDTO toReadPlanFeedbackResponseDTO(PlanFeedback planFeedback, long commentCount){
        return ReadPlanFeedbackResponseDTO.builder()
                .id(planFeedback.getId())
                .memberId(planFeedback.getMember().getId())
                .title(planFeedback.getTitle())
                .content(planFeedback.getContent())
                .memberName(planFeedback.getMember().getNickname())
                .memberImageUrl(planFeedback.getMember().getImageUrl())
                .imageUrls(planFeedback.getImages().stream()
                        .map(image -> image.getImageUrl())
                        .collect(Collectors.toList()))
                .fileUrls(planFeedback.getFiles().stream()
                        .map(file -> file.getFileUrl())
                        .collect(Collectors.toList()))
                .commentCount(commentCount)
                .createAt(planFeedback.getCreatedAt())
                .build();
    }

    public static ReadPlanFeedbackListResponseDTO toReadPlanFeedbackListResponseDTO(Page<PlanFeedback> planFeedbackPage, PlanCommentRepository planCommentRepository) {
        List<ReadPlanFeedbackResponseDTO> planFeedbackList = planFeedbackPage.getContent().stream()
                .map(planFeedback -> {
                    long commentCount = planCommentRepository.countByPlanFeedback_Id(planFeedback.getId());
                    return toReadPlanFeedbackResponseDTO(planFeedback, commentCount);
                })
                .collect(Collectors.toList());


        return ReadPlanFeedbackListResponseDTO.builder()
                .planFeedbackList(planFeedbackList)
                .totalPages(planFeedbackPage.getTotalPages())
                .totalFeedbacks(planFeedbackPage.getTotalElements())
                .build();
    }
}
