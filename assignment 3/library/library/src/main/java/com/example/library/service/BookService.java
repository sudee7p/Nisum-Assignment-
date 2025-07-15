package com.example.library.service;

import com.example.library.dto.BookDTO;
import java.util.List;

public interface BookService {
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO getBookById(Long id);
    List<BookDTO> getAllBooks();
    void deleteBook(Long id);
}
