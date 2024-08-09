package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.AdviceFeedbackFile;
import com.example.devcrew.domain.feedback.entity.DesignFeedbackFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignFeedbackFileRepository extends JpaRepository<DesignFeedbackFile, Long> {
}
