package com.bookStore.service;

import com.bookStore.entity.Film;

import java.util.List;

public interface FilmManager {
    public void save(Film b);
    public List<Film> getAllFilm();
    public Film getFilmById(int id);
    public void deleteById(int id);
}

