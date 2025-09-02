package com.library.management;

import com.library.management.controller.BookController;
import com.library.management.entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/library/management/ApplicationContext.xml");
        BookController controller = (BookController) context.getBean("bookController");

        // Test it
        controller.createBook(new Book("Java Basics", "Ayan", 499.99));
        controller.createBook(new Book("Hacking by MAK", "Ayan", 1499.99));
        controller.createBook(new Book("MERN stack", "Arish", 2499.99));
        controller.createBook(new Book("Mr 360", "Ab de villiers", 499.99));
        
        controller.showAllBooks();
    }
}
