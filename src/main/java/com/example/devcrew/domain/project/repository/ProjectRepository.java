package com.example.devcrew.domain.project.repository;

import com.example.devcrew.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
