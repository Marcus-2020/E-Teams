package com.marstechnologiesbr.eteams.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "id_player")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 30, message = "Name should have between 3 to 30 characters.")
    @NotBlank(message = "The player's name can't be blank.")
    @Column(name = "player_name")
    private String name;

    @Size(min = 3, message = "Last Name should have at least 3 characters.")
    @NotBlank(message = "The player's name can't be blank.")
    @Column(name = "player_last_name")
    private String lastName;

    private String fullName;

    @Size(min = 3, max = 30, message = "Function should have between 3 to 30 characters.")
    @NotBlank(message = "The player's function can't be blank.")
    @Column(name = "player_function")
    private String function;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id_team")
    private Team team;

    public Player(String name, String lastName, String function) {
        this.setName(name);
        this.setLastName(lastName);
        this.setFunction(function);
        this.setFullName();
    }

    public Player(){

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
        this.name = name.trim();
        this.setFullName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
        this.setFullName();
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public String getFullName() {
        return fullName;
    }

    private void setFullName() {
        if (this.name != null) {
            this.fullName = this.name + " " + this.lastName;
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
