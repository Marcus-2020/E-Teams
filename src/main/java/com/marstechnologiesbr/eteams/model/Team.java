package com.marstechnologiesbr.eteams.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "id_team")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 30, message = "")
    @NotBlank
    @Column(name = "team_name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
    }


    public Team() {
        this.players = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        if (player != null) {
            this.players.add(player);
        }
    }

    public void removePlayer(Player player) {
        if (player != null) {
            this.players.remove(player);
        }
    }
}
