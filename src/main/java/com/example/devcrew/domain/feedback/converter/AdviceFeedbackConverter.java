package com.example.devcrew.domain.feedback.converter;

import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class AdviceFeedbackConverter {

    // DTO to Entity(클라이언트에서 내부 엔티티로)

    // 게시글 생성 요청
    public static Feedback toadviceFeedback(CreateAdviceFeedbackRequestDTO request, Member member){

        FeedbackTag feedbackTag = switch (request.getFeedbackTag()) {
            case 1 -> FeedbackTag.PLAN;
            case 2 -> FeedbackTag.DESIGN;
            case 3 -> FeedbackTag.FRONTEND;
            case 4 -> FeedbackTag.BACKEND;
            case 5 -> FeedbackTag.OTHER;
            default -> throw new IllegalArgumentException("Unknown feedback tag: " + request.getFeedbackTag());
        };

        AdviceFeedback adviceFeedback = AdviceFeedback.builder()
                .feedbackTag(feedbackTag)
                .build();

        return Feedback.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .fileUrl(request.getFileUrl())
                .adviceFeedback(adviceFeedback)
                .member(member)
                .build();
    }

    // 게시글 생성 응답
    public static CreateAdviceFeedbackResponseDTO toCreateAdviceFeedbackResponseDTO(Feedback feedback) {
        return CreateAdviceFeedbackResponseDTO.builder()
                .id(feedback.getId())
                .memberId(feedback.getMember().getId())
                .createdAt(feedback.getCreatedAt())
                .updatedAt(feedback.getUpdatedAt())
                .build();
    }
}
