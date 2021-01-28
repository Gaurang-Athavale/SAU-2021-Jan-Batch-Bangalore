package com.assignment.library.bookOperations;

import com.assignment.library.entity.Book;
import com.assignment.library.entity.Student;
import java.util.ArrayList;

public class BookCart implements Runnable{
    private BlockedQueue blockedQueue;
    private Student student;
    private ArrayList<Book> bookList;

    public BookCart(BlockedQueue blockedQueue, Student student, ArrayList<Book> bookList) {
        super();
        this.blockedQueue = blockedQueue;
        this.student = student;
        this.bookList= bookList;
    }

    @Override
    public void run() {
        try {
            for(Book book : bookList) {
                book.getDetails();
                blockedQueue.addToCart(student, book);
            }
            System.out.println("YOUR SHOPPING CART: ");
            blockedQueue.listBooks();
            Thread t = new Thread(new BuyBooks(blockedQueue,student,bookList.get(0)));
            t.run();
            bookList.remove(0);

            if(bookList.size() > 0) {
                Thread.sleep(5000);
                for(Book book: bookList) {
                    blockedQueue.removeFromCart(student,book);
                }
            }
        }catch (Exception e) { }
    }
}
