package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.AdviceFeedback;
import com.example.devcrew.domain.feedback.entity.CodeFeedback;
import com.example.devcrew.domain.feedback.entity.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeFeedbackRepository extends JpaRepository<CodeFeedback, Long> {
    Page<CodeFeedback> findByLanguage(Language language, PageRequest pageRequest);

    Page<CodeFeedback> findAll(Pageable pageable);

}
