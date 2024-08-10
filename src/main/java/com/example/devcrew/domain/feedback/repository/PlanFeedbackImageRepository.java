package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.CodeFeedbackImage;
import com.example.devcrew.domain.feedback.entity.PlanFeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanFeedbackImageRepository extends JpaRepository<PlanFeedbackImage, Long> {
}
