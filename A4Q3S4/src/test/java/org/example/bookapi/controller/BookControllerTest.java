package org.example.bookapi.controller;

import org.example.bookapi.model.Book;
import org.example.bookapi.service.BookService;
import org.example.bookapi.exception.BookNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void testGetBook_Success() throws Exception {
        Book book = new Book(1L, "1984", "George Orwell");
        when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("1984"))
                .andExpect(jsonPath("$.author").value("George Orwell"));
    }

    @Test
    void testGetBook_NotFound() throws Exception {
        when(bookService.getBookById(2L)).thenThrow(new BookNotFoundException(2L));

        mockMvc.perform(get("/api/books/2"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Book Not Found"))
                .andExpect(jsonPath("$.detail").value("Book not found with ID: 2"));
    }
}
