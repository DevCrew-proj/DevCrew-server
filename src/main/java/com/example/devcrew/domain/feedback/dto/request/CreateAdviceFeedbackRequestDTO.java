package com.example.devcrew.domain.feedback.dto.request;

import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateAdviceFeedbackRequestDTO {

    @NotBlank
    private String title;   // 현직자 조언 게시글 제목

    @NotBlank
    private String content; // 현직자 조언 게시글 내용

    private FeedbackTag feedbackTag;    // 현직자 조언 태그

    private String fileUrl;  // 첨부 파일 리스트

//    MultipartFile feedbackImage;

}