package com.library.management.controller;

import com.library.management.entity.Book;
import com.library.management.service.BookService;

import java.util.List;

public class BookController {
    private BookService bookService;

    // setter for Spring injection
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void createBook(Book book) {
        bookService.addBook(book);
        System.out.println("Book added successfully: " + book);
    }

    public void showBook(int id) {
        Book book = bookService.getBookById(id);
        System.out.println(book != null ? book : "Book not found!");
    }

    public void showAllBooks() {
        List<Book> books = bookService.getAllBooks();
        books.forEach(System.out::println);
    }

    public void updateBook(Book book) {
        bookService.updateBook(book);
        System.out.println("Book updated successfully: " + book);
    }

    public void deleteBook(int id) {
        bookService.deleteBook(id);
        System.out.println("Book deleted with id " + id);
    }
}
