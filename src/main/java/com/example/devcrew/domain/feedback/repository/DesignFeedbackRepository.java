package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.DesignFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignFeedbackRepository extends JpaRepository<DesignFeedback, Long> {
}
