package com.hecatesmoon.book_api.DTO;

import com.hecatesmoon.book_api.model.Book;

public class BookResponse {
    
    private String title;
    private String author;
    private Integer pages;

    public BookResponse(){}

    public static BookResponse from (Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.title = book.getTitle();
        bookResponse.author = book.getAuthor();
        bookResponse.pages = book.getPages();
        return bookResponse;
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
