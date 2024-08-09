package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.AdviceFeedbackImage;
import com.example.devcrew.domain.feedback.entity.DesignFeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignFeedbackImageRepository extends JpaRepository<DesignFeedbackImage, Long> {
}
