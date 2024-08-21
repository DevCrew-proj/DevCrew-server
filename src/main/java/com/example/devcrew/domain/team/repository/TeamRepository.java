package com.example.devcrew.domain.team.repository;

import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.team.entity.Team;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {


    List<Team> findByContest(Contest contest);

    //Optional<Team> findByIdAndPassword(Long id, String password);
    Optional<Team> findById(Long id);


    @Query("SELECT t FROM Team t WHERE t.teamName = :teamName AND t.password = :password")
    List<Team> findByNameAndPassword(@Param("teamName") String teamName, @Param("password") String password);
    @Query("SELECT t FROM Team t WHERE t.teamName = :teamName")
    List<Team> findByName(@Param("teamName") String teamName);

}
