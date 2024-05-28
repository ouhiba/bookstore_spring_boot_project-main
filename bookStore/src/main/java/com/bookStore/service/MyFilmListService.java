package com.bookStore.service;

import com.bookStore.entity.MyFilmList;
import com.bookStore.repository.MyFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFilmListService implements MyFilmManager {

	@Autowired
	private MyFilmRepository myfilm;

	public void saveMyFilms(MyFilmList film) {
		myfilm.save(film);
	}

	public List<MyFilmList> getAllMyFilms(){
		return myfilm.findAll();
	}

	public boolean deleteById(int id) {

		try {
			myfilm.deleteById(id);
			return true; // Si la suppression est réussie, retourne true
		} catch (Exception e) {
			// Gérer l'exception ici
			e.printStackTrace(); // Affiche l'erreur dans la console, vous pouvez modifier cette partie pour un traitement personnalisé de l'erreur
			return false; // Retourne false en cas d'échec de la suppression
		}
	}
}
