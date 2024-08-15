package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.comment.repository.DesignCommentRepository;
import com.example.devcrew.domain.feedback.dto.request.CreateDesignFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.CreateDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DesignFeedbackConverter {

    public static DesignFeedback toDesignFeedback(CreateDesignFeedbackRequestDTO request, Member member){
        return DesignFeedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(member)
                .build();
    }

    public static CreateDesignFeedbackResponseDTO toCreateDesignFeedbackResponseDTO(DesignFeedback designFeedback){
        return CreateDesignFeedbackResponseDTO.builder()
                .id(designFeedback.getId())
                .memberId(designFeedback.getMember().getId())
                .createdAt(designFeedback.getCreatedAt())
                .updatedAt(designFeedback.getUpdatedAt())
                .build();
    }

    public static ReadDesignFeedbackResponseDTO toReadDesignFeedbackResponseDTO(DesignFeedback designFeedback, long commentCount){
        return ReadDesignFeedbackResponseDTO.builder()
                .id(designFeedback.getId())
                .memberId(designFeedback.getMember().getId())
                .title(designFeedback.getTitle())
                .content(designFeedback.getContent())
                .memberName(designFeedback.getMember().getNickname())
                .memberImageUrl(designFeedback.getMember().getImageUrl())
                .imageUrls(designFeedback.getImages().stream()
                        .map(image -> image.getImageUrl())
                        .collect(Collectors.toList()))
                .fileUrls(designFeedback.getFiles().stream()
                        .map(file -> file.getFileUrl())
                        .collect(Collectors.toList()))
                .commentCount(commentCount)
                .build();
    }

    public static ReadDesignFeedbackListResponseDTO toReadDesignFeedbackListResponseDTO(Page<DesignFeedback> designFeedbackPage, DesignCommentRepository designCommentRepository) {
        List<ReadDesignFeedbackResponseDTO> designFeedbackList = designFeedbackPage.getContent().stream()
                .map(designFeedback -> {
                    long commentCount = designCommentRepository.countByDesignFeedback_Id(designFeedback.getId());
                    return toReadDesignFeedbackResponseDTO(designFeedback, commentCount);
                })
                .collect(Collectors.toList());

        return ReadDesignFeedbackListResponseDTO.builder()
                .designFeedbackList(designFeedbackList)
                .totalPages(designFeedbackPage.getTotalPages())
                .totalFeedbacks(designFeedbackPage.getTotalElements())
                .build();
    }

}
