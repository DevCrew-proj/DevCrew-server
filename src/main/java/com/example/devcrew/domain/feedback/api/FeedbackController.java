package com.example.devcrew.domain.feedback.api;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackRequestDTO;

import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.CreateCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.service.CreateAdviceFeedbackImpl;
import com.example.devcrew.domain.feedback.service.CreateCodeFeedbackImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/feedback")
public class FeedbackController {

    private final CreateAdviceFeedbackImpl createAdviceFeedbackImpl;
    private final CreateCodeFeedbackImpl createCodeFeedbackImpl;

    // 현직자 조언 게시글 생성 API
    @PostMapping("/advice/create")
    @Operation(summary = "현직자 조언 게시글 생성 API")
    public ResponseEntity<CreateAdviceFeedbackResponseDTO> createAdivceFeedback(
            @Valid @RequestBody CreateAdviceFeedbackRequestDTO request) {

        Feedback newAdviceFeedback = createAdviceFeedbackImpl.createAdviceFeedback(request);
        CreateAdviceFeedbackResponseDTO responseDTO = AdviceFeedbackConverter.toCreateAdviceFeedbackResponseDTO(newAdviceFeedback);
        return ResponseEntity.ok(responseDTO);
    }

    // 코드 리뷰 게시글 생성 API
    @PostMapping("/code/create")
    @Operation(summary = "코드 리뷰 게시글 생성 API")
    public ResponseEntity<CreateCodeFeedbackResponseDTO> createCodeFeedback(
            @Valid @RequestBody CreateCodeFeedbackRequestDTO request){

        Feedback newCodeFeedback = createCodeFeedbackImpl.createCodeFeedback(request);
        CreateCodeFeedbackResponseDTO responseDTO = CodeFeedbackConverter.toCreateCodeFeedbackResponseDTO(newCodeFeedback);
        return ResponseEntity.ok(responseDTO);
    }


}
