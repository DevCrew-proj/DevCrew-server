    package com.example.devcrew.domain.feedback.converter;

    import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
    import com.example.devcrew.domain.feedback.dto.response.advicefeedback.CreateAdviceFeedbackResponseDTO;
    import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackListResponseDTO;
    import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackResponseDTO;
    import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
    import com.example.devcrew.domain.member.entity.Member;
    import org.springframework.data.domain.Page;
    import org.springframework.stereotype.Component;

    import java.util.List;
    import java.util.stream.Collectors;

    @Component
    public class AdviceFeedbackConverter {

        public static AdviceFeedback toAdviceFeedback(CreateAdviceFeedbackRequestDTO request, Member member){

            return AdviceFeedback.builder()
                    .title(request.getTitle())
                    .content(request.getContent())
                    .fileUrl(request.getFileUrl())
                    .feedbackTag(request.getFeedbackTag())
                    .member(member)
                    .build();
        }


        public static CreateAdviceFeedbackResponseDTO toCreateAdviceFeedbackResponseDTO(AdviceFeedback adviceFeedback) {
            return CreateAdviceFeedbackResponseDTO.builder()
                    .id(adviceFeedback.getId())
                    .memberId(adviceFeedback.getMember().getId())
                    .createdAt(adviceFeedback.getCreatedAt())
                    .updatedAt(adviceFeedback.getUpdatedAt())
                    .build();
        }


        public static ReadAdviceFeedbackResponseDTO toReadAdviceFeedbackResponseDTO(AdviceFeedback adviceFeedback) {
            return ReadAdviceFeedbackResponseDTO.builder()
                    .id(adviceFeedback.getId())
                    .title(adviceFeedback.getTitle())
                    .content(adviceFeedback.getContent())
                    .memberName(adviceFeedback.getMember().getNickname())
                    .build();
        }


        public static ReadAdviceFeedbackListResponseDTO toReadAdviceFeedbackListResponseDTO(Page<AdviceFeedback> adviceFeedbackPage) {
            List<ReadAdviceFeedbackResponseDTO> adviceFeedbackList = adviceFeedbackPage.getContent().stream()
                    .map(AdviceFeedbackConverter::toReadAdviceFeedbackResponseDTO)
                    .collect(Collectors.toList());

            return ReadAdviceFeedbackListResponseDTO.builder()
                    .adviceFeedbackList(adviceFeedbackList)
                    .totalPages(adviceFeedbackPage.getTotalPages())
                    .build();
        }
    }
