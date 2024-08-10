package com.example.devcrew.domain.contest.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class ContestNotFoundException extends BusinessException {
    public ContestNotFoundException() { super(ErrorCode.CONTEST_NOT_FOUND_ERROR); }
}
