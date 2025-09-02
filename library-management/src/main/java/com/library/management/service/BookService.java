package com.library.management.service;

import com.library.management.dao.BookDao;
import com.library.management.entity.Book;
import java.util.List;

public class BookService {
    
    private BookDao bookDao; // setter will inject DAO

    // Setter for Spring XML injection
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    // Business methods
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }
}
