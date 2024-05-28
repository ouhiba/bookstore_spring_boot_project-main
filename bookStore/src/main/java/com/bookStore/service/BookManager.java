package com.bookStore.service;

import com.bookStore.entity.Book;

import java.util.List;

public interface BookManager {
    public void save(Book b);
    public List<Book> getAllBook();
    public Book getBookById(int id);
    public void deleteById(int id);
    }

