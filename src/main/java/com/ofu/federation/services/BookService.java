package com.ofu.federation.services;

import com.ofu.federation.Repository.BookRepository;
import com.ofu.federation.dto.BookIn;
import com.ofu.federation.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo){
        this.repo = repo;
    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book addBook(BookIn bookin){
        Book book = new Book(String.valueOf(1+100*Math.random()),bookin.getName());
        return repo.save(book);
    }

    public Book getGOT(){
        return new Book("1","GOT");
    }

    public Book resolveById(String id) {
        if ("1".equals(id)) {
            return getGOT();
        } else {
            return null;
        }
    }

    public Book resolveFooReference(Map<String, Object> reference) {
        if (reference.get("id") instanceof String bookId) {
            return resolveById(bookId);
        } else {
            return null;
        }
    }
}