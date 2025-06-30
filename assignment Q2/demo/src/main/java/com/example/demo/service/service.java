package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public List<BookDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Optional<BookDTO> findById(Long id) {
        return repository.findById(id).map(this::toDto);
    }

    public BookDTO save(BookDTO dto) {
        Book book = repository.save(toEntity(dto));
        return toDto(book);
    }

    public Optional<BookDTO> update(Long id, BookDTO dto) {
        return repository.findById(id).map(b -> {
            b.setTitle(dto.getTitle());
            b.setAuthor(dto.getAuthor());
            b.setPublishedYear(dto.getPublishedYear());
            return toDto(repository.save(b));
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BookDTO toDto(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publishedYear(book.getPublishedYear())
                .build();
    }

    private Book toEntity(BookDTO dto) {
        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .publishedYear(dto.getPublishedYear())
                .build();
    }
}
