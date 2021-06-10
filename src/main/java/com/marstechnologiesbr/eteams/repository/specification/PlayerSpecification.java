package com.marstechnologiesbr.eteams.repository.specification;

import com.marstechnologiesbr.eteams.model.Player;
import com.marstechnologiesbr.eteams.model.Team;
import org.springframework.data.jpa.domain.Specification;

public class PlayerSpecification {

    public static Specification<Player> hasTeam(Team team) {
        return (player, cq, cb) -> cb.equal(player.get("team"), team);
    }

    public static Specification<Player> hasNotTeam(Team team) {
        return (player, cq, cb) -> cb.notEqual(player.get("team"), team);
    }
}
