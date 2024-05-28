package com.bookStore.controller;


import com.bookStore.entity.Film;
import com.bookStore.service.FilmManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FilmManager service;

    @GetMapping("")
    public String start() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public ModelAndView home() {

        List<Film> list = service.getAllFilm();
        return new ModelAndView("home", "film", list);

    }

}
