package com.example.devcrew.domain.comment.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class CommentFeedbackNotFoundException extends BusinessException {
    public CommentFeedbackNotFoundException() {
        super(ErrorCode.COMMENT_FEEDBACK_NOT_FOUND_ERROR);
    }
}
