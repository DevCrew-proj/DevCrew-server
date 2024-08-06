package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.feedback.dto.request.CreateFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.CreateFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.ReadFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeedbackConverter {

    public static Feedback toFeedback(CreateFeedbackRequestDTO request, Member member){
        return Feedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .fileUrl(request.getFileUrl())
                .member(member)
                .build();
    }

    public static CreateFeedbackResponseDTO toCreateFeedbackResponseDTO(Feedback feedback){
        return CreateFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .memberId(feedback.getMember().getId())
                .createdAt(feedback.getCreatedAt())
                .updatedAt(feedback.getUpdatedAt())
                .build();
    }

    public static ReadFeedbackResponseDTO toReadFeedbackResponseDTO(Feedback feedback){
        return ReadFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .title(feedback.getTitle())
                .content(feedback.getContent())
                .memberName(feedback.getMember().getNickname())
                .build();
    }

    public static ReadFeedbackListResponseDTO toReadFeedbackListResponseDTO(Page<Feedback> feedbackPage){
        List<ReadFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                .map(FeedbackConverter::toReadFeedbackResponseDTO)
                .collect(Collectors.toList());

        return ReadFeedbackListResponseDTO.builder()
                .feedbackList(feedbackList)

                .totalPages(feedbackPage.getTotalPages())
                .build();
    }

}
