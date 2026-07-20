package com.hecatesmoon.book_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hecatesmoon.book_api.dto.BookRequest;
import com.hecatesmoon.book_api.dto.BookResponse;
import com.hecatesmoon.book_api.service.BooksService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BooksService booksService;

    BookController (BooksService booksService){
        this.booksService = booksService;
    }


    @GetMapping("")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        
        return ResponseEntity.ok(booksService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id){
        return ResponseEntity.ok(booksService.findById(id));
    }
    
    @PostMapping("")
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) {
        BookResponse newBook = booksService.create(bookRequest);
        return ResponseEntity.ok(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable Long id){
        Map<String, String> response = new HashMap<>();
        response.put("message", "the book (id "+id+") was deleted succesfully");
        booksService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> putMethodName(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        
        BookResponse response = booksService.update(id, bookRequest);
        
        return ResponseEntity.ok(response);
    }
    
}
