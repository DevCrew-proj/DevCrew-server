package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.FeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackImageRepository extends JpaRepository<FeedbackImage, Long> {
}
