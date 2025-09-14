package com.sanket.day5_book_store_api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    // Getters & Setters
    private int id;
    private String title;
    private String author;
    private double price;
    private String genre;

    public Book() {}

    public Book(int id, String title, String author, double price, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
    }

}
