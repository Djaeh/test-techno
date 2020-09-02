package com.example.demo.rest.bookresource;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
public class BookResource {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("api/book/{isbn}")
    public Book getBook(@PathVariable("isbn") String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            return book;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found");
    }

    @PostMapping("api/book")
    public String addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "ok";
    }
}
