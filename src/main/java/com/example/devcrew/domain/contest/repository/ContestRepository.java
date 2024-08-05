package com.example.devcrew.domain.contest.repository;

import com.example.devcrew.domain.contest.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {
}
