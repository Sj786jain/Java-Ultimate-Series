package com.sanket.day6_combined_api.controller;

import com.sanket.day6_combined_api.entity.Book;
import com.sanket.day6_combined_api.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin("*")
public class BookController {
    private final BookService service;
    public BookController(BookService service) { this.service = service; }

    @GetMapping
    public List<Book> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Book create(@RequestBody Book b) { return service.create(b); }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book b) { return service.update(id, b); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String author) { return service.searchByAuthor(author); }
}
