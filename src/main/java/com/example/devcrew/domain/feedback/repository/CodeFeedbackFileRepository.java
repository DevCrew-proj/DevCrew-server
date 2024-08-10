package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.AdviceFeedbackFile;
import com.example.devcrew.domain.feedback.entity.CodeFeedbackFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeFeedbackFileRepository extends JpaRepository<CodeFeedbackFile, Long> {
}
