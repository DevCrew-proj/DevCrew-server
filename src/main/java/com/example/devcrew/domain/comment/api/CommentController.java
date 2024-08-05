package com.example.devcrew.domain.comment.api;

import com.example.devcrew.domain.comment.converter.CommentConverter;
import com.example.devcrew.domain.comment.dto.request.PostCommentRequestDTO;
import com.example.devcrew.domain.comment.dto.response.GetCommentResponseDTO;
import com.example.devcrew.domain.comment.dto.response.PostCommentResponseDTO;
import com.example.devcrew.domain.comment.entity.Comment;
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

    // 댓글 생성 API 구현
    @PostMapping("/{feedbackID}/comments")
    public ResponseEntity<PostCommentResponseDTO> createComment(
            @PathVariable Long feedbackID,
            @RequestBody PostCommentRequestDTO request,
            @RequestParam Long memberId) {

        Comment newComment = createCommentImpl.createComment(feedbackID, memberId, request);
        PostCommentResponseDTO responseDTO = CommentConverter.toPostCommentResponseDTO(newComment);

        return ResponseEntity.ok(responseDTO);
    }

    // 댓글 조회 API 구현
    @GetMapping("/{feedbackId}/comments")
    public ResponseEntity<GetCommentResponseDTO> getComments(@PathVariable Long feedbackId) {
        List<Comment> comments = readCommentImpl.getComments(feedbackId);
        GetCommentResponseDTO responseDTO = CommentConverter.toGetCommentResponseDTO(comments);

        return ResponseEntity.ok(responseDTO);
    }

}
