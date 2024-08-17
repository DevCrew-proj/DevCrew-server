package com.example.devcrew.domain.feedback.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class FeedbackNotFoundException extends BusinessException {
    public FeedbackNotFoundException() {
        super(ErrorCode.FEEDBACK_NOT_FOUND_ERROR);
    }
}
