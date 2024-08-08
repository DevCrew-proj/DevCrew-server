package com.example.devcrew.domain.team.repository;

import com.example.devcrew.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    //Optional<Team> findByIdAndPassword(Long id, String password);
    Optional<Team> findById(Long id);
}