    package com.example.devcrew.domain.feedback.converter;

    import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
    import com.example.devcrew.domain.feedback.dto.response.CreateAdviceFeedbackResponseDTO;
    import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackListResponseDTO;
    import com.example.devcrew.domain.feedback.dto.response.ReadAdviceFeedbackResponseDTO;
    import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
    import com.example.devcrew.domain.feedback.entity.Feedback;
    import com.example.devcrew.domain.feedback.entity.FeedbackTag;
    import com.example.devcrew.domain.member.entity.Member;
    import org.springframework.data.domain.Page;
    import org.springframework.stereotype.Component;

    import java.util.List;
    import java.util.stream.Collectors;

    @Component
    public class AdviceFeedbackConverter {

        // DTO to Entity(클라이언트에서 내부 엔티티로)

        // 게시글 생성 요청
        public static Feedback toadviceFeedback(CreateAdviceFeedbackRequestDTO request, Member member){

            AdviceFeedback adviceFeedback = AdviceFeedback.builder()
                    .feedbackTag(request.getFeedbackTag()) // 바로 request에서 FeedbackTag를 받아옴
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

        // 게시글 단일 조회 응답
        public static ReadAdviceFeedbackResponseDTO toReadAdviceFeedbackResponseDTO(Feedback feedback) {
            return ReadAdviceFeedbackResponseDTO.builder()
                    .id(feedback.getId())
                    .title(feedback.getTitle())
                    .content(feedback.getContent())
                    .memberName(feedback.getMember().getNickname())
                    .build();
        }

        // 게시글 목록 조회 응답
        public static ReadAdviceFeedbackListResponseDTO toReadAdviceFeedbackListResponseDTO(Page<Feedback> feedbackPage) {
            List<ReadAdviceFeedbackResponseDTO> feedbackList = feedbackPage.getContent().stream()
                    .map(AdviceFeedbackConverter::toReadAdviceFeedbackResponseDTO)
                    .collect(Collectors.toList());

            return ReadAdviceFeedbackListResponseDTO.builder()
                    .adviceFeedbackList(feedbackList)
                    .totalPages(feedbackPage.getTotalPages())
                    .build();
        }
    }
