package com.assignment.library.bookOperations;

import com.assignment.library.entity.Book;
import com.assignment.library.entity.Student;

public class BuyBooks implements Runnable{
    private BlockedQueue blockedQueue;
    private Student student;
    private Book book;

    public BuyBooks(BlockedQueue blockedQueue, Student student, Book book) {
        super();
        this.blockedQueue = blockedQueue;
        this.student = student;
        this.book= book;
    }

    @Override
    public void run() {
        try {
            blockedQueue.checkout(student,book);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
