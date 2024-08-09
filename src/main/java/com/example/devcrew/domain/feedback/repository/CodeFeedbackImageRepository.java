package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.AdviceFeedbackFile;
import com.example.devcrew.domain.feedback.entity.CodeFeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeFeedbackImageRepository extends JpaRepository<CodeFeedbackImage, Long> {
}
