package com.marstechnologiesbr.eteams.repository;

import com.marstechnologiesbr.eteams.model.Player;
import com.marstechnologiesbr.eteams.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, JpaSpecificationExecutor<Player> {

    List<Player> findByNameContainingIgnoreCase(final String name);

    List<Player> findAllByTeamIsNull();
}
