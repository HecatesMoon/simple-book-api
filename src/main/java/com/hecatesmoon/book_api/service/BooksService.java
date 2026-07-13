package com.hecatesmoon.book_api.service;

import java.util.List;

import com.hecatesmoon.book_api.dto.BookRequest;
import com.hecatesmoon.book_api.dto.BookResponse;
import com.hecatesmoon.book_api.exception.BookNotFoundException;
import com.hecatesmoon.book_api.model.Book;
import com.hecatesmoon.book_api.repository.BooksRepository;

public class BooksService {
    
    private final BooksRepository booksRepository;

    public BooksService (BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    List<BookResponse> findAll(){
        return booksRepository.findAll().stream().map(BookResponse::from).toList();
    }

    BookResponse findById(Long id){
        Book book = booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book was not found, id: " + id) );
        return BookResponse.from(book);
    }

    BookResponse create(BookRequest r){
        Book book = booksRepository.save(BookRequest.toEntity(r));
        return BookResponse.from(book);
    }

    void delete(Long id){
        booksRepository.deleteById(id);
    }
}
