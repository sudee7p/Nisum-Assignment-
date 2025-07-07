package org.example.bookapi.service;

import org.example.bookapi.model.Book;

public interface BookService {
    Book getBookById(Long id);
}