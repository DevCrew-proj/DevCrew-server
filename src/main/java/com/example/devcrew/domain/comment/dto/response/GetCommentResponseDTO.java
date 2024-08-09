package com.example.devcrew.domain.comment.dto.response;

import com.example.devcrew.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCommentResponseDTO {
    private List<SingleCommentResponseDTO> comments;
}