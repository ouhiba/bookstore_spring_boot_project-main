package com.bookStore.service;

import com.bookStore.entity.MyFilmList;

import java.util.List;

public interface MyFilmManager {
    public void saveMyFilms(MyFilmList film) ;


    public List<MyFilmList> getAllMyFilms();

    public boolean deleteById(int id) ;
}
