package org.example.book;

import org.example.library.model.Book;
import org.example.library.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    private Book sampleBook;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        sampleBook = new Book();
        sampleBook.setTitle("Effective Java");
        sampleBook.setAuthor("Joshua Bloch");
        sampleBook.setPublishedYear(2018);
        repository.save(sampleBook);
    }

    @Test
    void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Effective Java")));
    }

    @Test
    void testGetBookById() throws Exception {
        mockMvc.perform(get("/books/" + sampleBook.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author", is("Joshua Bloch")));
    }

    @Test
    void testCreateBook() throws Exception {
        Book newBook = new Book();
        newBook.setTitle("Clean Code");
        newBook.setAuthor("Robert C. Martin");
        newBook.setPublishedYear(2008);

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Clean Code")));
    }

    @Test
    void testUpdateBook() throws Exception {
        sampleBook.setAuthor("J. Bloch");

        mockMvc.perform(put("/books/" + sampleBook.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author", is("J. Bloch")));
    }

    @Test
    void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/" + sampleBook.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/books"))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
