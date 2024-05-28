package com.bookStore.controller;

import com.bookStore.service.MyFilmManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my_films")
public class MyFilmListController {

	@Autowired
	private MyFilmManager service;

	@RequestMapping("/deleteMyFilm/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_films";
	}
}
