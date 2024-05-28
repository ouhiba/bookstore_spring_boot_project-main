package com.bookStore.controller;

import com.bookStore.entity.Film;
import com.bookStore.entity.MyFilmList;
import com.bookStore.service.FilmManager;
import com.bookStore.service.MyBookManager;
import com.bookStore.service.MyFilmManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

	@Autowired
	private FilmManager service;

	@Autowired
	private MyFilmManager myfilmservice;

	@Autowired
	private MyFilmManager myFilmService;



	@GetMapping("/registere")
	public String filmRegister() {
		return "filmRegister";
	}

	@GetMapping("/availablee")
	public ModelAndView getAllFilm() {
		List<Film> list = service.getAllFilm();
		return new ModelAndView("filmList", "film", list);
	}

	@PostMapping("/savee")
	public String addFilm(@ModelAttribute Film b) {
		service.save(b);
		return "redirect:/films/availablee";
	}

	@GetMapping("/my_films")
	public String getMyFilms(Model model) {
		List<MyFilmList> list = myFilmService.getAllMyFilms();
		model.addAttribute("films", list); // Changement ici
		return "myFilms";
	}

	@RequestMapping("/myliste/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Film b = service.getFilmById(id);
		MyFilmList mb = new MyFilmList(b.getId(), b.getName(), b.getAuthor(), b.getPrice(),b.getCategory(),b.getImage(),b.getDescription());
		myFilmService.saveMyFilms(mb);
		return "redirect:/films/my_films";
	}

	@RequestMapping("/edite/{id}")
	public String editFilm(@PathVariable("id") int id, Model model) {
		Film b = service.getFilmById(id);
		model.addAttribute("film", b);
		return "filmEdit";
	}

	@RequestMapping("/deletee/{id}")
	public String deleteFilm(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/films/availablee";
	}

	@GetMapping("/deleteMyFilm")
	public String deleteLaboratoire(Model model, @RequestParam(name = "id") Integer id) {
		if (myfilmservice.deleteById(id)) {
			return "redirect:/films/my_films";
		} else {
			return "error";
		}
	}
}
