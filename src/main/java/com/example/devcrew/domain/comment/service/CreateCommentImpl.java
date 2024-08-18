package com.example.devcrew.domain.comment.service;

import com.example.devcrew.domain.auth.service.AuthService;
import com.example.devcrew.domain.comment.converter.CommentConverter;
import com.example.devcrew.domain.comment.dto.request.PostCommentRequestDTO;
import com.example.devcrew.domain.comment.entity.AdviceComment;
import com.example.devcrew.domain.comment.entity.CodeComment;
import com.example.devcrew.domain.comment.entity.DesignComment;
import com.example.devcrew.domain.comment.entity.PlanComment;
import com.example.devcrew.domain.comment.exception.CommentFeedbackNotFoundException;
import com.example.devcrew.domain.comment.exception.CommentMemberNotFoundException;
import com.example.devcrew.domain.comment.repository.AdviceCommentRepository;
import com.example.devcrew.domain.comment.repository.CodeCommentRepository;
import com.example.devcrew.domain.comment.repository.DesignCommentRepository;
import com.example.devcrew.domain.comment.repository.PlanCommentRepository;
import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import com.example.devcrew.domain.feedback.entity.PlanFeedback;
import com.example.devcrew.domain.feedback.repository.AdviceFeedbackRepository;
import com.example.devcrew.domain.feedback.repository.CodeFeedbackRepository;
import com.example.devcrew.domain.feedback.repository.DesignFeedbackRepository;
import com.example.devcrew.domain.feedback.repository.PlanFeedbackRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import com.example.devcrew.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateCommentImpl {

    private final CodeCommentRepository codeCommentRepository;
    private final AdviceCommentRepository adviceCommentRepository;
    private final DesignCommentRepository designCommentRepository;
    private final PlanCommentRepository planCommentRepository;

    private final MemberRepository memberRepository;

    private final CodeFeedbackRepository codeFeedbackRepository;
    private final AdviceFeedbackRepository adviceFeedbackRepository;
    private final DesignFeedbackRepository designFeedbackRepository;
    private final PlanFeedbackRepository planFeedbackRepository;

    private final AuthService authService;


    @Transactional
    public CodeComment createCodeComment(Long feedbackId, PostCommentRequestDTO request) {
        Long memberId = authService.getLoginUserId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CommentMemberNotFoundException());
        CodeFeedback codeFeedback = codeFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new CommentFeedbackNotFoundException());
        CodeComment codeComment = CommentConverter.toCodeComment(request);

        codeComment.setMembertoComment(member);
        codeComment.setFeedbacktoComment(codeFeedback);

        return codeCommentRepository.save(codeComment);
    }

    @Transactional
    public AdviceComment createAdviceComment(Long feedbackId, PostCommentRequestDTO request) {
        Long memberId = authService.getLoginUserId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CommentMemberNotFoundException());
        AdviceFeedback adviceFeedback = adviceFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new CommentFeedbackNotFoundException());

        AdviceComment adviceComment = CommentConverter.toAdviceComment(request);

        adviceComment.setMembertoComment(member);
        adviceComment.setFeedbacktoComment(adviceFeedback);

        return adviceCommentRepository.save(adviceComment);
    }

    @Transactional
    public DesignComment createDesignComment(Long feedbackId, PostCommentRequestDTO request) {
        Long memberId = authService.getLoginUserId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CommentMemberNotFoundException());
        DesignFeedback designFeedback = designFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new CommentFeedbackNotFoundException());


        DesignComment designComment = CommentConverter.toDesignComment(request);

        designComment.setMembertoComment(member);
        designComment.setFeedbacktoComment(designFeedback);

        return designCommentRepository.save(designComment);
    }

    @Transactional
    public PlanComment createPlanComment(Long feedbackId, PostCommentRequestDTO request) {
        Long memberId = authService.getLoginUserId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CommentMemberNotFoundException());
        PlanFeedback planFeedback = planFeedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new CommentFeedbackNotFoundException());

        PlanComment planComment = CommentConverter.toPlanComment(request);

        planComment.setMembertoComment(member);
        planComment.setFeedbacktoComment(planFeedback);

        return planCommentRepository.save(planComment);
    }
}
