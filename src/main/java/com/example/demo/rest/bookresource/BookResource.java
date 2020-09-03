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
    public Book getBook(@PathVariable("isbn") String isbn, @RequestHeader("X-tenantID") String tenant) {
        Book book = bookRepository.findByIsbnAndTenantId(isbn, tenant);
        if (book != null) {
            return book;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found");
    }

    @PostMapping("api/book")
    public String addBook(@RequestBody Book book, @RequestHeader("X-tenantID") String tenant) {
        //Setting the tenant only for the book is not good enough.
        // we need to set the tenant for every sub object.
        //here we should create two more POJO class BookRest and AuthorRest and map them to Book and Author
        //then we can make sure during the mapping that every object have the tenantID...
        book.setTenantId(tenant);
        bookRepository.save(book);
        return "ok";
    }
}
