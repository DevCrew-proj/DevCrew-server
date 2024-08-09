package com.example.devcrew.domain.feedback.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateDesignFeedbackRequestDTO {
    @NotBlank
    private String title;   // 코드 리뷰 게시글 제목

    @NotBlank
    private String content; // 코드 리뷰 게시글 내용


    private List<String> fileUrls;  // 첨부 파일 리스트

    private List<String> imageUrls; // 첨부 이미지 리스트
}
