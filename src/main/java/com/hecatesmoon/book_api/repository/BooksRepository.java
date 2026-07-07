package com.hecatesmoon.book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hecatesmoon.book_api.model.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{
    
}
