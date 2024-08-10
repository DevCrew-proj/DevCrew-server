package com.example.devcrew.domain.comment.service;

import com.example.devcrew.domain.comment.entity.AdviceComment;
import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.comment.entity.DesignComment;
import com.example.devcrew.domain.comment.entity.PlanComment;
import com.example.devcrew.domain.comment.repository.AdviceCommentRepository;
import com.example.devcrew.domain.comment.repository.CodeCommentRepository;
import com.example.devcrew.domain.comment.repository.DesignCommentRepository;
import com.example.devcrew.domain.comment.repository.PlanCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReadCommentImpl {
    private final CodeCommentRepository codeCommentRepository;
    private final AdviceCommentRepository adviceCommentRepository;
    private final DesignCommentRepository designCommentRepository;
    private final PlanCommentRepository planCommentRepository;

    @Transactional
    public List<CodeComment> getCodeComments(Long feedbackId) {
        return codeCommentRepository.findByCodeFeedback_Id(feedbackId);
    }

    @Transactional
    public List<AdviceComment> getAdviceComments(Long feedbackId) {
        return adviceCommentRepository.findByAdviceFeedback_Id(feedbackId);
    }

    @Transactional
    public List<DesignComment> getDesignComments(Long feedbackId) {
        return designCommentRepository.findByDesignFeedback_Id(feedbackId);
    }

    @Transactional
    public List<PlanComment> getPlanComments(Long feedbackId) {
        return planCommentRepository.findByPlanFeedback_Id(feedbackId);
    }


}
