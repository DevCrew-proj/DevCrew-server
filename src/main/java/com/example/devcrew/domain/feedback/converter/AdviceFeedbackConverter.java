    package com.example.devcrew.domain.feedback.converter;

    import com.example.devcrew.domain.comment.repository.AdviceCommentRepository;
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


        public static ReadAdviceFeedbackResponseDTO toReadAdviceFeedbackResponseDTO(AdviceFeedback adviceFeedback, long commentCount) {
            return ReadAdviceFeedbackResponseDTO.builder()
                    .id(adviceFeedback.getId())
                    .memberId(adviceFeedback.getMember().getId())
                    .title(adviceFeedback.getTitle())
                    .content(adviceFeedback.getContent())
                    .memberName(adviceFeedback.getMember().getNickname())
                    .memberImageUrl(adviceFeedback.getMember().getImageUrl())
                    .imageUrls(adviceFeedback.getImages().stream()
                            .map(image -> image.getImageUrl())
                            .collect(Collectors.toList()))
                    .fileUrls(adviceFeedback.getFiles().stream()
                            .map(file -> file.getFileUrl())
                            .collect(Collectors.toList()))
                    .commentCount(commentCount)
                    .feedbackTag(adviceFeedback.getFeedbackTag().getFeedbackTag())
                    .createAt(adviceFeedback.getCreatedAt())
                    .build();
        }


        public static ReadAdviceFeedbackListResponseDTO toReadAdviceFeedbackListResponseDTO(Page<AdviceFeedback> adviceFeedbackPage, AdviceCommentRepository adviceCommentRepository) {
            List<ReadAdviceFeedbackResponseDTO> adviceFeedbackList = adviceFeedbackPage.getContent().stream()
                    .map(adviceFeedback -> {
                        long commentCount = adviceCommentRepository.countByAdviceFeedback_Id(adviceFeedback.getId());
                        return toReadAdviceFeedbackResponseDTO(adviceFeedback, commentCount);
                    })
                    .collect(Collectors.toList());

            return ReadAdviceFeedbackListResponseDTO.builder()
                    .adviceFeedbackList(adviceFeedbackList)
                    .totalPages(adviceFeedbackPage.getTotalPages())
                    .totalFeedbacks(adviceFeedbackPage.getTotalElements())
                    .build();
        }
    }
