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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<CodeComment> getCodeComments(Long feedbackId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return codeCommentRepository.findByCodeFeedback_Id(feedbackId, pageRequest);
    }

    @Transactional
    public Page<AdviceComment> getAdviceComments(Long feedbackId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return adviceCommentRepository.findByAdviceFeedback_Id(feedbackId, pageRequest);
    }

    @Transactional
    public Page<DesignComment> getDesignComments(Long feedbackId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return designCommentRepository.findByDesignFeedback_Id(feedbackId, pageRequest);
    }

    @Transactional
    public Page<PlanComment> getPlanComments(Long feedbackId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return planCommentRepository.findByPlanFeedback_Id(feedbackId, pageRequest);
    }


}
