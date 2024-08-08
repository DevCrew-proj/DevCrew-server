package com.example.devcrew.domain.comment.repository;

import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.comment.entity.DesignComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DesignCommentRepository extends JpaRepository<DesignComment, Long> {
    // 특정 게시글의 모든 댓글 조회
    List<DesignComment> findByDesignFeedback_Id(Long designFeedbackId);
}
