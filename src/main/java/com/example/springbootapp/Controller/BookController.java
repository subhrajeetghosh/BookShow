package com.example.springbootapp.Controller;

import com.example.springbootapp.Entity.Book;
import com.example.springbootapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookRepository bookrepository;
    @GetMapping("postgres")
    public List<Book> getAllBook() {
        this.bookrepository.findAll();
    }

}
