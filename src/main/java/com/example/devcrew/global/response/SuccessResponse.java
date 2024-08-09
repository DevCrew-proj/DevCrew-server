package com.example.devcrew.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class SuccessResponse {
    private final boolean success = true;
    private final LocalDateTime timeStamp;
    private final int status;
    private final Object data;

    public SuccessResponse(Object data, int status) {
        this.timeStamp = LocalDateTime.now();
        this.status=status;
        this.data = data;
    }
}
