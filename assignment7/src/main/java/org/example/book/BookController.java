package org.example.book;

import org.example.library.model.Book;
import org.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existing = repository.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPublishedYear(book.getPublishedYear());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

