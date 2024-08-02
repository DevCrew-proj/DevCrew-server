package com.example.devcrew.domain.feedback.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCodeFeedbackRequestDTO {

    @NotBlank
    private String title;   // 코드 리뷰 게시글 제목

    @NotBlank
    private String content; // 코드 리뷰 게시글 내용

    @NotNull
    private Integer language;    // 태그를 번호로 받을 것

    private String fileUrl;  // 첨부 파일 리스트
}
