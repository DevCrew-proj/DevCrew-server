package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.AdviceFeedbackFile;
import com.example.devcrew.domain.feedback.entity.AdviceFeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdviceFeedbackImageRepository extends JpaRepository<AdviceFeedbackImage, Long> {
}
