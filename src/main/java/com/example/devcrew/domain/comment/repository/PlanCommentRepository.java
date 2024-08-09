package com.example.devcrew.domain.comment.repository;

import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.comment.entity.PlanComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanCommentRepository extends JpaRepository<PlanComment, Long> {
    // 특정 게시글의 모든 댓글 조회
    List<PlanComment> findByPlanFeedback_Id(Long planFeedbackId);
}