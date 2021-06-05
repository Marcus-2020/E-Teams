package com.marstechnologiesbr.etimes.controller;

import com.marstechnologiesbr.etimes.model.Player;
import com.marstechnologiesbr.etimes.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PlayerCreationSuccessController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/player-creation-success")
    public ModelAndView playerCreationSuccess(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("response-pages/player-creation-success");

        return modelAndView;
    }


    @RequestMapping(value = "/player-creation-success", method = RequestMethod.POST)
    public ModelAndView createPlayer(@Valid @ModelAttribute Player player, BindingResult result) {
        final ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("new-player");
            return modelAndView;
        }

        playerRepository.save(player);
        modelAndView.setViewName("response-pages/player-creation-success");
        modelAndView.addObject("player", player);

        return modelAndView;
    }
}
