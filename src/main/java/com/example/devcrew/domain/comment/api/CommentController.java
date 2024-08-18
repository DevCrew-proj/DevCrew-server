package com.example.devcrew.domain.comment.api;

import com.example.devcrew.domain.comment.converter.CommentConverter;
import com.example.devcrew.domain.comment.dto.request.PostCommentRequestDTO;
import com.example.devcrew.domain.comment.dto.response.GetCommentResponseDTO;
import com.example.devcrew.domain.comment.dto.response.PostCommentResponseDTO;
import com.example.devcrew.domain.comment.entity.AdviceComment;
import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.comment.entity.DesignComment;
import com.example.devcrew.domain.comment.entity.PlanComment;
import com.example.devcrew.domain.comment.service.CreateCommentImpl;
import com.example.devcrew.domain.comment.service.ReadCommentImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/feedback")
public class CommentController {

    private final CreateCommentImpl createCommentImpl;
    private final ReadCommentImpl readCommentImpl;

    @PostMapping("/advices/{feedbackID}/comments")
    @Operation(summary = "현직자 조언 게시글 댓글 생성 API")
    public ResponseEntity<PostCommentResponseDTO> createAdviceComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request) {

        AdviceComment newComment = createCommentImpl.createAdviceComment(feedbackID, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostAdviceCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/advices/{feedbackId}/comments")
    @Operation(summary = "현직자 조언 게시글 댓글 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<GetCommentResponseDTO> getAdviceComments(
            @PathVariable Long feedbackId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {

        Page<AdviceComment> commentsPage = readCommentImpl.getAdviceComments(feedbackId, page, size);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetAdviceCommentResponseDTO(commentsPage.getContent(), commentsPage.getTotalPages());

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/codes/{feedbackID}/comments")
    @Operation(summary = "코드 리뷰 게시글 댓글 생성 API")
    public ResponseEntity<PostCommentResponseDTO> createCodeComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request) {

        CodeComment newComment = createCommentImpl.createCodeComment(feedbackID, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostCodeCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/codes/{feedbackId}/comments")
    @Operation(summary = "코드 리뷰 게시글 댓글 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<GetCommentResponseDTO> getCodeComments(
            @PathVariable Long feedbackId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {

        Page<CodeComment> commentsPage = readCommentImpl.getCodeComments(feedbackId, page, size);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetCodeCommentResponseDTO(commentsPage.getContent(), commentsPage.getTotalPages());

        return ResponseEntity.ok(responseDTO);
    }


    @PostMapping("/designs/{feedbackID}/comments")
    @Operation(summary = "디자인 피드백 게시글 댓글 생성 API")
    public ResponseEntity<PostCommentResponseDTO> createDesignComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request) {

        DesignComment newComment = createCommentImpl.createDesignComment(feedbackID, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostDesignCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/designs/{feedbackId}/comments")
    @Operation(summary = "디자인 피드백 게시글 댓글 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<GetCommentResponseDTO> getDesignComments(@PathVariable Long feedbackId,
                                                                   @RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "6") int size) {

        Page<DesignComment> commentsPage = readCommentImpl.getDesignComments(feedbackId, page, size);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetDesignCommentResponseDTO(commentsPage.getContent(), commentsPage.getTotalPages());

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/plans/{feedbackID}/comments")
    @Operation(summary = "기획 피드백 게시글 댓글 생성 API")
    public ResponseEntity<PostCommentResponseDTO> createPlanComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request) {

        PlanComment newComment = createCommentImpl.createPlanComment(feedbackID, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostPlanCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/plans/{feedbackId}/comments")
    @Operation(summary = "기획 피드백 게시글 댓글 조회 API")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ResponseEntity<GetCommentResponseDTO> getPlanComments(@PathVariable Long feedbackId,
                                                                 @RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "6") int size) {

        Page<PlanComment> commentsPage = readCommentImpl.getPlanComments(feedbackId, page, size);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetPlanCommentResponseDTO(commentsPage.getContent(), commentsPage.getTotalPages());


        return ResponseEntity.ok(responseDTO);
    }


}
