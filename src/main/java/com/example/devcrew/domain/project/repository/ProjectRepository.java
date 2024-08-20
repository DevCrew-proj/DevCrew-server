package com.example.devcrew.domain.project.repository;

import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.project.entity.Project;
import com.example.devcrew.domain.project.entity.ProjectTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.projectImages WHERE p.member = :member ORDER BY p.id DESC")
    Page<Project> findProjectsWithImagesByMember(@Param("member") Member member, Pageable pageable);

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.projectImages WHERE p.id = :projectId  ORDER BY p.id DESC")
    Optional<Project> findRecruitWithImagesById(@Param("projectId") Long projectId);

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.projectImages WHERE p.member = :member AND p.projectTag = :projectTag ORDER BY p.id DESC")
    Page<Project> findProjectsByMemberAndProjectTag(@Param("member") Member member, @Param("projectTag") ProjectTag projectTag, Pageable pageable);

}
