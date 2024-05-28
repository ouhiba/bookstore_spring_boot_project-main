package com.bookStore.service;

import com.bookStore.entity.MyBookList;

import java.util.List;

public interface MyBookManager {
    public void saveMyBooks(MyBookList book) ;


    public List<MyBookList> getAllMyBooks();

    public boolean deleteById(int id) ;
}
