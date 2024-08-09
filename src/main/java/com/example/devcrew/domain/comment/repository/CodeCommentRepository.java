package com.example.devcrew.domain.comment.repository;

import com.example.devcrew.domain.comment.entity.CodeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeCommentRepository extends JpaRepository<CodeComment, Long> {
    // 특정 게시글의 모든 댓글 조회
    List<CodeComment> findByCodeFeedback_Id(Long codeFeedbackId);
}