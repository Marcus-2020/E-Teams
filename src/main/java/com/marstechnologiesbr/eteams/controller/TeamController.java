package com.marstechnologiesbr.eteams.controller;

import com.marstechnologiesbr.eteams.model.Player;
import com.marstechnologiesbr.eteams.model.Team;
import com.marstechnologiesbr.eteams.repository.PlayerRepository;
import com.marstechnologiesbr.eteams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TeamController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team/{team_id}")
    public ModelAndView team(@PathVariable("team_id") final Long teamId){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");

        final Optional<Team> team = teamRepository.findById(teamId);

        if (team.isPresent()) {
            modelAndView.addObject("team", team.get());
        } else {
            Team empityTeam = new Team();
            empityTeam.setName("Não Encontrado");
            modelAndView.addObject("team", empityTeam);
        }

        modelAndView.addObject("allPlayers",
                playerRepository.findAllByTeamIsNull());
        modelAndView.addObject("player", null);

        return modelAndView;
    }

    @RequestMapping(value = "/team/{team_id}/players/add-player", method = RequestMethod.POST)
    public ModelAndView addPlayer(@PathVariable("team_id") final Long teamId,
                            @RequestParam(name = "player") final Long playerId) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");
        final  Optional<Player> player = playerRepository.findById(playerId);
        final Optional<Team> team = teamRepository.findById(teamId);

        if (player.isPresent() && team.isPresent()) {
            player.get().setTeam(team.get());
            playerRepository.save(player.get());
            modelAndView.addObject("team", team.get());
            modelAndView.addObject("allPlayers",
                    playerRepository.findAllByTeamIsNull());
            modelAndView.addObject("player", null);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/team/{team_id}/players/remove-player", method = RequestMethod.POST)
    public ModelAndView removePlayer(@PathVariable("team_id") final Long teamId,
                                  @RequestParam(name = "player") final Long playerId) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");
        final  Optional<Player> player = playerRepository.findById(playerId);
        final Optional<Team> team = teamRepository.findById(teamId);

        if (player.isPresent() && team.isPresent()) {
            player.get().setTeam(null);
            playerRepository.save(player.get());
            modelAndView.addObject("team", team.get());
            modelAndView.addObject("allPlayers",
                    playerRepository.findAllByTeamIsNull());
            modelAndView.addObject("player", null);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/team/{team_id}/alter-team-name", method = RequestMethod.POST)
    public ModelAndView alterPlayerName(@PathVariable("team_id") final Long teamId,
                                        @RequestParam(name = "team-name") final String teamName) {
        final ModelAndView modelAndView = team(teamId);
        final Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            team.get().setName(teamName);
            teamRepository.save(team.get());
            modelAndView.getModel().remove("team");
            modelAndView.addObject("team", team.get());
        }

        return modelAndView;
    }

}
