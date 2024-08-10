package com.example.devcrew.domain.contest.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class AcceptancePeriodInvalidException extends BusinessException {
    public AcceptancePeriodInvalidException() {
        super(ErrorCode.INVALID_ACCEPTANCE_PERIOD);
    }
}
