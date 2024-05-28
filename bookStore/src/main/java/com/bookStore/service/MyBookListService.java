package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookRepository;

@Service
public class MyBookListService implements MyBookManager {
	
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public boolean deleteById(int id) {
		try {
			mybook.deleteById(id);
			return true; // Si la suppression est réussie, retourne true
		} catch (Exception e) {
			// Gérer l'exception ici
			e.printStackTrace(); // Affiche l'erreur dans la console, vous pouvez modifier cette partie pour un traitement personnalisé de l'erreur
			return false; // Retourne false en cas d'échec de la suppression
		}
	}
}
