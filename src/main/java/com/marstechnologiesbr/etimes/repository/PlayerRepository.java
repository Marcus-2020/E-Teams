package com.marstechnologiesbr.etimes.repository;

import com.marstechnologiesbr.etimes.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByNameContainingIgnoreCase(final String name);
}
