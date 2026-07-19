package com.hecatesmoon.book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hecatesmoon.book_api.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{
    
}
