package com.example.devcrew.domain.team.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class DuplicateTeamException extends BusinessException {
    public DuplicateTeamException() {
        super(ErrorCode.DUPLICATE_TEAM);
    }
}
