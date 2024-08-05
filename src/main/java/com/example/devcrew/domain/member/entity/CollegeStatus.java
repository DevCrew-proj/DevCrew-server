package com.example.devcrew.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CollegeStatus {

    ENROLLMENT("재학"),
    ON_LEAVE("휴학"),
    GRADUATION("졸업");

    private final String status;
}

// http://localhost:8080/social-login?exist=false&Authorization=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBY2Nlc3NUb2tlbiIsImV4cCI6MTcyMzQ0OTIyMiwiZW1haWwiOiJ0bWRybDc3NzdAZ21haWwuY29tIn0.Xov49Mvjm2t9nxWb3w7-u1AZqm3c7NNp-F15yKXu522YxQ-hIBqkInwa4Unf0uXNGaDoZV34JLfAexxwoYzGxg