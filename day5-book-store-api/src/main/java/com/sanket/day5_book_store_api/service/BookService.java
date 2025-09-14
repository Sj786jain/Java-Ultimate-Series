package com.sanket.day5_book_store_api.service;

import com.sanket.day5_book_store_api.dto.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private Map<Integer, Book> bookStore = new HashMap<>();
    private int nextId = 1;

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    public Book getBookById(int id) {
        return bookStore.get(id);
    }

    public Book addBook(Book book) {
        book.setId(nextId++);
        bookStore.put(book.getId(), book);
        return book;
    }

    public Book updateBook(int id, Book updatedBook) {
        if (bookStore.containsKey(id)) {
            updatedBook.setId(id); // preserve ID
            bookStore.put(id, updatedBook);
            return updatedBook;
        }
        return null;
    }

    public boolean deleteBook(int id) {
        return bookStore.remove(id) != null;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : bookStore.values()) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
}
