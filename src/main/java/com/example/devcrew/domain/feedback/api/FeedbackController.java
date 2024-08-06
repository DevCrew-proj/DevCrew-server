package com.example.devcrew.domain.feedback.api;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;

import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.*;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.feedback.entity.Language;
import com.example.devcrew.domain.feedback.service.CreateAdviceFeedbackImpl;
import com.example.devcrew.domain.feedback.service.CreateCodeFeedbackImpl;
import com.example.devcrew.domain.feedback.service.ReadAdviceFeedbackImpl;
import com.example.devcrew.domain.feedback.service.ReadCodeFeedbackImpl;
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
    private final ReadAdviceFeedbackImpl readAdviceFeedbackImpl;
    private final ReadCodeFeedbackImpl readCodeFeedbackImpl;

    @PostMapping("/advice/create")
    @Operation(summary = "현직자 조언 게시글 생성 API")
    public ResponseEntity<CreateAdviceFeedbackResponseDTO> createAdivceFeedback(
            @Valid @RequestBody CreateAdviceFeedbackRequestDTO request) {

        Feedback newAdviceFeedback = createAdviceFeedbackImpl.createAdviceFeedback(request);
        CreateAdviceFeedbackResponseDTO responseDTO = AdviceFeedbackConverter.toCreateAdviceFeedbackResponseDTO(newAdviceFeedback);
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping("/advices/{feedbackId}")
    @Operation(summary = "현직자 조언 단일 게시글 조회 API")
    public ResponseEntity<ReadAdviceFeedbackResponseDTO> readAdviceFeedback(@PathVariable Long feedbackId){
        ReadAdviceFeedbackResponseDTO responseDTO = readAdviceFeedbackImpl.readAdviceFeedback(feedbackId);
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping("/advices")
    @Operation(summary = "현직자 조언 게시글 목록 조회 API")
    public ResponseEntity<ReadAdviceFeedbackListResponseDTO> readAdviceFeedbackList(
            @RequestParam FeedbackTag feedbackTag,
            @RequestParam int page) {

        ReadAdviceFeedbackListResponseDTO responseDTO = readAdviceFeedbackImpl.readAdviceFeedbackList(feedbackTag, page);
        return ResponseEntity.ok(responseDTO);
    }


    @PostMapping("/code/create")
    @Operation(summary = "코드 리뷰 게시글 생성 API")
    public ResponseEntity<CreateCodeFeedbackResponseDTO> createCodeFeedback(
            @Valid @RequestBody CreateCodeFeedbackRequestDTO request){

        Feedback newCodeFeedback = createCodeFeedbackImpl.createCodeFeedback(request);
        CreateCodeFeedbackResponseDTO responseDTO = CodeFeedbackConverter.toCreateCodeFeedbackResponseDTO(newCodeFeedback);
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping("/codes/{feedbackId}")
    @Operation(summary = "코드 리뷰 단일 게시글 조회 API")
    public ResponseEntity<ReadCodeFeedbackResponseDTO> readCodeFeedback(@PathVariable Long feedbackId){
        ReadCodeFeedbackResponseDTO responseDTO = readCodeFeedbackImpl.readCodeFeedback(feedbackId);
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping("/codes")
    @Operation(summary = "코드 리뷰 게시글 목록 조회 API")
    public ResponseEntity<ReadCodeFeedbackListResponseDTO> readCodeFeedbackList(
            @RequestParam Language language,
            @RequestParam int page) {

        ReadCodeFeedbackListResponseDTO responseDTO = readCodeFeedbackImpl.readCodeFeedbackList(language, page);
        return ResponseEntity.ok(responseDTO);
    }


}
