package com.ofu.federation.controller;

import com.ofu.federation.dto.BookIn;
import com.ofu.federation.model.Book;
import com.ofu.federation.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @QueryMapping
    public Book getDefault(@Argument String id) {
        return bookService.resolveById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookIn bookIn){
        return bookService.addBook(bookIn);
    }
}