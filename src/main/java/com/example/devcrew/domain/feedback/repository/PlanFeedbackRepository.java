package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.PlanFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanFeedbackRepository extends JpaRepository<PlanFeedback, Long> {
}
