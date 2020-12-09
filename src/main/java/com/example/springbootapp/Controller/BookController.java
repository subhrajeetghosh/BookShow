package com.example.springbootapp.Controller;

import com.example.springbootapp.Entity.Book;
import com.example.springbootapp.Exception.ResourceNotFoundException;
import com.example.springbootapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookRepository bookrepository;
    //get all books
    @GetMapping("postgres")
    public List<Book> getAllBook() {
        return this.bookrepository.findAll();
    }
    //get books by id
    @GetMapping("/postgres/{Id}")
    public ResponseEntity<Book> getEmployeeById(@PathVariable(value = "Id") int Id)
            throws ResourceNotFoundException {
        Book book = bookrepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));
        return ResponseEntity.ok().body(book);
    }
    @PostMapping("postgres")
    public Book createBook(@RequestBody Book book) {
        return this.bookrepository.save(book);
    }
}
