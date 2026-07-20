package com.hecatesmoon.book_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hecatesmoon.book_api.dto.BookRequest;
import com.hecatesmoon.book_api.dto.BookResponse;
import com.hecatesmoon.book_api.exception.BookNotFoundException;
import com.hecatesmoon.book_api.model.Book;
import com.hecatesmoon.book_api.repository.BooksRepository;

@Service
public class BooksService {
    
    private final BooksRepository booksRepository;

    public BooksService (BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<BookResponse> findAll(){
        return booksRepository.findAll().stream().map(BookResponse::from).toList();
    }

    public BookResponse findById(Long id){
        Book book = booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book was not found, id: " + id) );
        return BookResponse.from(book);
    }

    public BookResponse create(BookRequest r){
        Book book = booksRepository.save(BookRequest.toEntity(r));
        return BookResponse.from(book);
    }

    public void delete(Long id){
        booksRepository.deleteById(id);
    }

    //TODO: read more about @Transactional
    public BookResponse update(Long id, BookRequest r){
        Book book = booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book was not found, id: " + id));
        Book newBook = BookRequest.toEntity(r);

        newBook.setId(id);
        newBook.setCreatedAt(book.getCreatedAt());
        newBook.setUpdatedAt(book.getUpdatedAt());

        newBook = booksRepository.save(newBook);
        return BookResponse.from(newBook);
    }
}
