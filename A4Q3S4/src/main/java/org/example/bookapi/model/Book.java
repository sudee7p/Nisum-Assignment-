package org.example.bookapi.model;


public class Book {
    private Long id;
    private String title;
    private String author;

    // Constructors, getters, setters
    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters (or use Lombok @Data)
}
