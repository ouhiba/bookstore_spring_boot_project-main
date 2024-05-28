package com.bookStore.service;

import com.bookStore.entity.Film;
import com.bookStore.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements FilmManager{

	@Autowired
	private FilmRepository bRepo;

	public void save(Film b) {
		bRepo.save(b);
	}

	public List<Film> getAllFilm(){
		return bRepo.findAll();
	}

	public Film getFilmById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
