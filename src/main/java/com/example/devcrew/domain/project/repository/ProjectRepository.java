package com.example.devcrew.domain.project.repository;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByMember(Member member);

}
