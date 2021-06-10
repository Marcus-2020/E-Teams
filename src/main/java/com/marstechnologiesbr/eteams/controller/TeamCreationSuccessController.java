package com.marstechnologiesbr.eteams.controller;

import com.marstechnologiesbr.eteams.model.Team;
import com.marstechnologiesbr.eteams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TeamCreationSuccessController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team-creation-success")
    public ModelAndView teamCreationSuccess(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team-creation-success");

        return modelAndView;
    }

    @RequestMapping(value = "/team-creation-success", method = RequestMethod.POST)
    public ModelAndView createTeam(@Valid @ModelAttribute Team team, BindingResult result) {
        final ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("new-team");
            return modelAndView;
        }

        teamRepository.save(team);
        modelAndView.setViewName("response-pages/team-creation-success");
        modelAndView.addObject("team", team);

        return modelAndView;
    }
}

