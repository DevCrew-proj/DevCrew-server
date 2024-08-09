package com.example.devcrew.domain.team.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class InvalidTeamPasswordException extends BusinessException {
    public InvalidTeamPasswordException() { super(ErrorCode.INVALID_TEAM_PASSWORD); }
}
