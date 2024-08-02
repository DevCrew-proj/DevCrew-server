package com.example.devcrew.domain.feedback.repository;

import com.example.devcrew.domain.feedback.entity.Feedback;
import com.example.devcrew.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    Page<Feedback> findByMember(Member member, PageRequest pageRequest);
}
