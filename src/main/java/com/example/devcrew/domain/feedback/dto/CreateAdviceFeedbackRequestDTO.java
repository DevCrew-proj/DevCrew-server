package com.example.devcrew.domain.feedback.dto;

import com.example.devcrew.domain.feedback.entity.FeedbackImage;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class CreateAdviceFeedbackRequestDTO {

    @NotBlank
    private String title;   // 현직자 조언 게시글 제목

    @NotBlank
    private String content; // 현직자 조언 게시글 내용

    @NotNull
    private Integer feedbackTag;    // 태그를 번호로 받을 것

    private String fileUrl;  // 첨부 파일 리스트

//    MultipartFile feedbackImage;

}
