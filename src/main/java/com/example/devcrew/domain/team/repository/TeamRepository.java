package com.example.devcrew.domain.team.repository;

import com.example.devcrew.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByIdAndPassword(Long id, String password);
}
