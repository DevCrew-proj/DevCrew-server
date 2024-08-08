package com.example.devcrew.domain.project.repository;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.projectImages WHERE p.member = :member ORDER BY p.id DESC")
    Optional<List<Project>> findProjectsWithImagesByMember(@Param("member") Member member);

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.projectImages WHERE p.id = :projectId  ORDER BY p.id DESC")
    Optional<Project> findRecruitWithImagesById(@Param("projectId") Long projectId);

}
