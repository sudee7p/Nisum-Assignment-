package com.example.library.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private String title;
    private String author;
    private String isbn;
}
