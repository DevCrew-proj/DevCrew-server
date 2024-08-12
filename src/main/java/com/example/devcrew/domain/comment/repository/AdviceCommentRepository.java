package com.example.devcrew.domain.comment.repository;

import com.example.devcrew.domain.comment.entity.AdviceComment;
import com.example.devcrew.domain.comment.entity.CodeComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdviceCommentRepository extends JpaRepository<AdviceComment, Long> {
    // 특정 게시글의 모든 댓글 조회
    Page<AdviceComment> findByAdviceFeedback_Id(Long adviceFeedbackId, Pageable pageable);
}
