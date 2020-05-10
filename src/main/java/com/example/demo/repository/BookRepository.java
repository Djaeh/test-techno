package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book,Long> {

    public Book findByIsbn(String isbn);
}
