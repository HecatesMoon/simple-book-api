package com.hecatesmoon.book_api.DTO;

import com.hecatesmoon.book_api.model.Book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequest {
    @NotBlank(message = "Please write the title of the book")
    private String title;
    @NotBlank(message = "Please write the author of the book")
    private String author;
    @NotNull(message = "Please write how many pages does the book have")
    @Min(value=3, message = "Write a number greater thatn 0")
    private Integer pages;

    public BookRequest(){}

    public static Book toEntity (BookRequest bookRequest){
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPages(bookRequest.getPages());
        return book;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPages() {
        return pages;
    }

    
}
