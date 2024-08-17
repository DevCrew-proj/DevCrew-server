package com.example.devcrew.domain.comment.exception;

import com.example.devcrew.global.error.ErrorCode;
import com.example.devcrew.global.error.exception.BusinessException;

public class CommentMemberNotFoundException extends BusinessException {
    public CommentMemberNotFoundException() {
        super(ErrorCode.COMMENT_MEMBER_NOT_FOUND_ERROR);
    }
}
