package com.example.devcrew.domain.feedback.api;
import com.example.devcrew.domain.feedback.converter.*;

import com.example.devcrew.domain.feedback.dto.request.CreateAdviceFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreateCodeFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreateDesignFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.request.CreatePlanFeedbackRequestDTO;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.CreateAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.advicefeedback.ReadAdviceFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.CreateCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.codefeedback.ReadCodeFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.CreateDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.designfeedback.ReadDesignFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.CreatePlanFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.ReadPlanFeedbackListResponseDTO;
import com.example.devcrew.domain.feedback.dto.response.planfeedback.ReadPlanFeedbackResponseDTO;
import com.example.devcrew.domain.feedback.entity.*;
import com.example.devcrew.domain.feedback.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
    private final CreateDesignFeedbackImpl createDesignFeedbackImpl;
    private final CreatePlanFeedbackImpl createPlanFeedbackImpl;

    private final ReadAdviceFeedbackImpl readAdviceFeedbackImpl;
    private final ReadCodeFeedbackImpl readCodeFeedbackImpl;
    private final ReadDesignFeedbackImpl readDesignFeedbackImpl;
    private final ReadPlanFeedbackImpl readPlanFeedbackImpl;


    @PostMapping("/advice/create")
    @Operation(summary = "현직자 조언 게시글 생성 API")
    public ResponseEntity<CreateAdviceFeedbackResponseDTO> createAdivceFeedback(
            @Valid @RequestBody CreateAdviceFeedbackRequestDTO request) {

        AdviceFeedback newAdviceFeedback = createAdviceFeedbackImpl.createAdviceFeedback(request);
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
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<ReadAdviceFeedbackListResponseDTO> readAdviceFeedbackList(
            @RequestParam FeedbackTag feedbackTag,
            @RequestParam int page) {

        ReadAdviceFeedbackListResponseDTO responseDTO = readAdviceFeedbackImpl.readAdviceFeedbackList(feedbackTag, page);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/advices/all")
    @Operation(summary = "현직자 조언 전체 게시글 목록 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<ReadAdviceFeedbackListResponseDTO> readAllAdviceFeedbackList(
            @RequestParam int page) {

        ReadAdviceFeedbackListResponseDTO responseDTO = readAdviceFeedbackImpl.readAllAdviceFeedbackList(page);
        return ResponseEntity.ok(responseDTO);
    }


    @PostMapping("/code/create")
    @Operation(summary = "코드 리뷰 게시글 생성 API")
    public ResponseEntity<CreateCodeFeedbackResponseDTO> createCodeFeedback(
            @Valid @RequestBody CreateCodeFeedbackRequestDTO request){

        CodeFeedback newCodeFeedback = createCodeFeedbackImpl.createCodeFeedback(request);
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
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<ReadCodeFeedbackListResponseDTO> readCodeFeedbackList(
            @RequestParam Language language,
            @RequestParam int page) {

        ReadCodeFeedbackListResponseDTO responseDTO = readCodeFeedbackImpl.readCodeFeedbackList(language, page);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/codes/all")
    @Operation(summary = "코드 리뷰 전체 게시글 목록 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<ReadCodeFeedbackListResponseDTO> readAllCodeFeedbackList(
            @RequestParam int page) {

        ReadCodeFeedbackListResponseDTO responseDTO = readCodeFeedbackImpl.readAllCodeFeedbackList(page);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/plan/create")
    @Operation(summary = "기획 피드백 게시글 생성 API")
    public ResponseEntity<CreatePlanFeedbackResponseDTO> createPlanFeedback(
            @Valid @RequestBody CreatePlanFeedbackRequestDTO request){

        PlanFeedback newPlanFeedback = createPlanFeedbackImpl.createPlanFeedback(request);
        CreatePlanFeedbackResponseDTO responseDTO = PlanFeedbackConverter.toCreatePlanFeedbackResponseDTO(newPlanFeedback);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/plans/{feedbackId}")
    @Operation(summary = "기획 피드백 단일 게시글 조회 API")
    public ResponseEntity<ReadPlanFeedbackResponseDTO> readPlanFeedback(@PathVariable Long feedbackId){
        ReadPlanFeedbackResponseDTO planResponseDTO = readPlanFeedbackImpl.readPlanFeedback(feedbackId);
        return ResponseEntity.ok(planResponseDTO);
    }

    @GetMapping("/plans")
    @Operation(summary = "기획 피드백 게시글 목록 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<ReadPlanFeedbackListResponseDTO> readPlanFeedbackList(
            @RequestParam int page) {

        ReadPlanFeedbackListResponseDTO responseDTO = readPlanFeedbackImpl.readPlanFeedbackList(page);
        return ResponseEntity.ok(responseDTO);
    }



    @PostMapping("/design/create")
    @Operation(summary = "디자인 피드백 게시글 생성 API")
    public ResponseEntity<CreateDesignFeedbackResponseDTO> createDesignFeedback(
            @Valid @RequestBody CreateDesignFeedbackRequestDTO request){

        DesignFeedback newDesignFeedback = createDesignFeedbackImpl.createDesignFeedback(request);
        CreateDesignFeedbackResponseDTO responseDTO = DesignFeedbackConverter.toCreateDesignFeedbackResponseDTO(newDesignFeedback);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/designs/{feedbackId}")
    @Operation(summary = "디자인 피드백 단일 게시글 조회 API")
    public ResponseEntity<ReadDesignFeedbackResponseDTO> readDesignFeedback(@PathVariable Long feedbackId){
        ReadDesignFeedbackResponseDTO designResponseDTO = readDesignFeedbackImpl.readDesignFeedback(feedbackId);
        return ResponseEntity.ok(designResponseDTO);
    }

    @GetMapping("/designs")
    @Operation(summary = "디자인 피드백 게시글 목록 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<ReadDesignFeedbackListResponseDTO> readDesignFeedbackList(
            @RequestParam int page) {

        ReadDesignFeedbackListResponseDTO responseDTO = readDesignFeedbackImpl.readDesignFeedbackList(page);
        return ResponseEntity.ok(responseDTO);
    }



}
