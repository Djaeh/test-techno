package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book,Long> {

    public Book findByIsbnAndTenantId(String isbn, String tenant);
    //Should be careful here. If no tenant we should not save the book...
    public Book save(Book book);
}
