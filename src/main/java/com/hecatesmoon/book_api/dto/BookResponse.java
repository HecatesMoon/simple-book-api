package com.hecatesmoon.book_api.dto;

import com.hecatesmoon.book_api.model.Book;

public class BookResponse {
    
    private Long id;
    private String title;
    private String author;
    private Integer pages;

    public BookResponse(){}

    public static BookResponse from (Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.id = book.getId();
        bookResponse.title = book.getTitle();
        bookResponse.author = book.getAuthor();
        bookResponse.pages = book.getPages();
        return bookResponse;
    }

    public Long getId() {
        return id;
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
