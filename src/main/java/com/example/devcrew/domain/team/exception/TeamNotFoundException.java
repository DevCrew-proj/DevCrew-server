package com.example.devcrew.domain.team.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class TeamNotFoundException extends BusinessException {
    public TeamNotFoundException() { super(ErrorCode.TEAM_NOT_FOUND_ERROR);
    }
}
