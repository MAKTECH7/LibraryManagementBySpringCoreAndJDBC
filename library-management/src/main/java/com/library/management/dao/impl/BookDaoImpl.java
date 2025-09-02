package com.library.management.dao.impl;

import com.library.management.dao.BookDao;
import com.library.management.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class BookDaoImpl implements BookDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addBook(Book book) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                 "INSERT INTO books (title, author, price) VALUES (?,?,?)")) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                 "SELECT * FROM books WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book();  // default constructor
                book.setId(rs.getInt("id"));           // set id from DB
                book.setTitle(rs.getString("title"));  // set title
                book.setAuthor(rs.getString("author"));// set author
                book.setPrice(rs.getDouble("price"));  // set price
            }
            } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

            while (rs.next()) {
                Book book = new Book();               // default constructor
                book.setId(rs.getInt("id"));          // set id from DB
                book.setTitle(rs.getString("title")); // set title
                book.setAuthor(rs.getString("author"));// set author
                book.setPrice(rs.getDouble("price")); // set price
                list.add(book);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateBook(Book book) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                 "UPDATE books SET title=?, author=?, price=? WHERE id=?")) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getId());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                 "DELETE FROM books WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
