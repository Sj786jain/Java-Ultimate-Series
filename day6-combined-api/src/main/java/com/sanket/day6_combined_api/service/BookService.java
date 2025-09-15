package com.sanket.day6_combined_api.service;

import com.sanket.day6_combined_api.entity.Book;
import com.sanket.day6_combined_api.exception.ResourceNotFoundException;
import com.sanket.day6_combined_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) { this.repo = repo; }

    public List<Book> getAll() { return repo.findAll(); }
    public Book getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }
    public Book create(Book b) { return repo.save(b); }
    public Book update(Long id, Book updated) {
        Book b = getById(id);
        b.setTitle(updated.getTitle());
        b.setAuthor(updated.getAuthor());
        b.setGenre(updated.getGenre());
        b.setPrice(updated.getPrice());
        return repo.save(b);
    }
    public void delete(Long id) { repo.deleteById(id); }

    public List<Book> searchByAuthor(String author) { return repo.findByAuthorContainingIgnoreCase(author); }
}
