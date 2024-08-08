package com.example.devcrew.global.config;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SuccessResponse {
    private final boolean success = true;
    private final LocalDateTime timeStamp;
    private final Object data;

    public SuccessResponse(Object data) {
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }
}
