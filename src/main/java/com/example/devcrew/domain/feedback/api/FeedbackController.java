package com.example.devcrew.domain.feedback.api;
import com.example.devcrew.domain.feedback.converter.AdviceFeedbackConverter;
import com.example.devcrew.domain.feedback.converter.CodeFeedbackConverter;

import com.example.devcrew.domain.feedback.converter.FeedbackConverter;
import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreateFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.*;
import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.feedback.entity.FeedbackTag;
import com.example.devcrew.domain.feedback.entity.Language;
import com.example.devcrew.domain.feedback.service.*;
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
    private final CreateFeedbackImpl createFeedbackImpl;

    private final ReadAdviceFeedbackImpl readAdviceFeedbackImpl;
    private final ReadCodeFeedbackImpl readCodeFeedbackImpl;
    private final ReadFeedbackImpl readFeedbackImpl;


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

    @PostMapping("/plan/create")
    @Operation(summary = "기획 피드백 게시글 생성 API")
    public ResponseEntity<CreateFeedbackResponseDTO> createPlanFeedback(
            @Valid @RequestBody CreateFeedbackRequestDTO request){

        Feedback newPlanFeedback = createFeedbackImpl.createFeedback(request);
        CreateFeedbackResponseDTO responseDTO = FeedbackConverter.toCreateFeedbackResponseDTO(newPlanFeedback);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/plans/{feedbackId}")
    @Operation(summary = "기획 피드백 단일 게시글 조회 API")
    public ResponseEntity<ReadFeedbackResponseDTO> readPlanFeedback(@PathVariable Long feedbackId){
        ReadFeedbackResponseDTO planResponseDTO = readFeedbackImpl.readFeedback(feedbackId);
        return ResponseEntity.ok(planResponseDTO);
    }

    @GetMapping("/plans")
    @Operation(summary = "기획 피드백 게시글 목록 조회 API")
    public ResponseEntity<ReadFeedbackListResponseDTO> readPlanFeedbackList(
            @RequestParam int page) {

        ReadFeedbackListResponseDTO responseDTO = readFeedbackImpl.readFeedbackList(page);
        return ResponseEntity.ok(responseDTO);
    }



    @PostMapping("/design/create")
    @Operation(summary = "디자인 피드백 게시글 생성 API")
    public ResponseEntity<CreateFeedbackResponseDTO> createDesignFeedback(
            @Valid @RequestBody CreateFeedbackRequestDTO request){

        Feedback newDesignFeedback = createFeedbackImpl.createFeedback(request);
        CreateFeedbackResponseDTO responseDTO = FeedbackConverter.toCreateFeedbackResponseDTO(newDesignFeedback);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/designs/{feedbackId}")
    @Operation(summary = "디자인 피드백 단일 게시글 조회 API")
    public ResponseEntity<ReadFeedbackResponseDTO> readDesignFeedback(@PathVariable Long feedbackId){
        ReadFeedbackResponseDTO designResponseDTO = readFeedbackImpl.readFeedback(feedbackId);
        return ResponseEntity.ok(designResponseDTO);
    }



}
