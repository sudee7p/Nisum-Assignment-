package com.example.library.exception;

/**
 * Custom exception when a book is not found.
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
