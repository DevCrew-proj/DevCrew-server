package com.example.devcrew.domain.feedback.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateDesignFeedbackRequestDTO {
    @NotBlank
    private String title;   // 코드 리뷰 게시글 제목

    @NotBlank
    private String content; // 코드 리뷰 게시글 내용


    private String fileUrl;  // 첨부 파일 리스트
}
