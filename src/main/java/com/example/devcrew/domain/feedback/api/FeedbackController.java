package com.example.devcrew.domain.feedback.api;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackRequestDTO;

import com.example.devcrew.domain.feedback.dto.CreateAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.service.CreateAdviceFeedbackImpl;
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

    // 현직자 조언 게시글 생성 API
    @PostMapping("/advice/create")
    @Operation(summary = "현직자 조언 게시글 생성 API")
    public ResponseEntity<CreateAdviceFeedbackResponseDTO> createAdivceFeedback(
            @Valid @RequestBody CreateAdviceFeedbackRequestDTO request) {

        Feedback feedback = createAdviceFeedbackImpl.createAdviceFeedback(request);
        CreateAdviceFeedbackResponseDTO responseDTO = AdviceFeedbackConverter.toCreateAdviceFeedbackResponseDTO(feedback);
        return ResponseEntity.ok(responseDTO);
    }


}
