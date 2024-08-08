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
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<PostCommentResponseDTO> createAdviceComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request,
            @RequestParam Long memberId) {

        AdviceComment newComment = createCommentImpl.createAdviceComment(feedbackID, memberId, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostAdviceCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/advices/{feedbackId}/comments")
    public ResponseEntity<GetCommentResponseDTO> getAdviceComments(@PathVariable Long feedbackId) {
        List<AdviceComment> comments = readCommentImpl.getAdviceComments(feedbackId);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetAdviceCommentResponseDTO(comments);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/codes/{feedbackID}/comments")
    public ResponseEntity<PostCommentResponseDTO> createCodeComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request,
            @RequestParam Long memberId) {

        CodeComment newComment = createCommentImpl.createCodeComment(feedbackID, memberId, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostCodeCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/codes/{feedbackId}/comments")
    public ResponseEntity<GetCommentResponseDTO> getCodeComments(@PathVariable Long feedbackId) {
        List<CodeComment> comments = readCommentImpl.getCodeComments(feedbackId);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetCodeCommentResponseDTO(comments);

        return ResponseEntity.ok(responseDTO);
    }


    @PostMapping("/designs/{feedbackID}/comments")
    public ResponseEntity<PostCommentResponseDTO> createDesignComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request,
            @RequestParam Long memberId) {

        DesignComment newComment = createCommentImpl.createDesignComment(feedbackID, memberId, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostDesignCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/designs/{feedbackId}/comments")
    public ResponseEntity<GetCommentResponseDTO> getDesignComments(@PathVariable Long feedbackId) {
        List<DesignComment> comments = readCommentImpl.getDesignComments(feedbackId);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetDesignCommentResponseDTO(comments);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/plans/{feedbackID}/comments")
    public ResponseEntity<PostCommentResponseDTO> createPlanComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request,
            @RequestParam Long memberId) {

        PlanComment newComment = createCommentImpl.createPlanComment(feedbackID, memberId, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostPlanCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/plans/{feedbackId}/comments")
    public ResponseEntity<GetCommentResponseDTO> getPlanComments(@PathVariable Long feedbackId) {
        List<PlanComment> comments = readCommentImpl.getPlanComments(feedbackId);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetPlanCommentResponseDTO(comments);

        return ResponseEntity.ok(responseDTO);
    }





}
