package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.CodeFeedbackFile;
import com.example.devcrew.domain.feedback.entity.PlanFeedbackFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanFeedbackFileRepository extends JpaRepository<PlanFeedbackFile, Long> {
}
