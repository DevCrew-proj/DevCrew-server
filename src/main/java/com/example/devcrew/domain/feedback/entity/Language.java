package com.example.devcrew.domain.feedback.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Language {
    JAVA("JAVA"),
    JAVASCRIPT("JS"),
    KOTLIN("Kotlin"),
    PYTHON("Python"),
    SWIFT("Swift"),
    C("C"),
    OTHER("기타");

    private final String language;
}
