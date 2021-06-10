package com.marstechnologiesbr.eteams.repository;

import com.marstechnologiesbr.eteams.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByNameContainingIgnoreCase(final String name);
}