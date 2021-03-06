package com.marstechnologiesbr.etimes.controller;

import com.marstechnologiesbr.etimes.model.Player;
import com.marstechnologiesbr.etimes.model.Team;
import com.marstechnologiesbr.etimes.repository.PlayerRepository;
import com.marstechnologiesbr.etimes.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/index")
    public ModelAndView index(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("allPlayers", playerRepository.findAll());
        modelAndView.addObject("allTeams", teamRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/new-player")
    public ModelAndView newPlayer() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-player");

        modelAndView.addObject("player", new Player());

        return modelAndView;
    }

    @GetMapping("/new-team")
    public ModelAndView newTeam() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-team");

        modelAndView.addObject("team", new Team());

        return modelAndView;
    }

}
