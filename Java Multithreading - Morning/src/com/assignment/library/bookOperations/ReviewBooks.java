package com.assignment.library.bookOperations;

import com.assignment.library.entity.Book;
import com.assignment.library.entity.Student;
import java.util.ArrayList;

public class ReviewBooks implements Runnable{
    private BlockedQueue blockedQueue;
    private Student student;
    private ArrayList<Book> book;

    public ReviewBooks(BlockedQueue blockedQueue, Student student, ArrayList<Book> book) {
        super();
        this.blockedQueue = blockedQueue;
        this.student = student;
        this.book= book;
    }
    @Override
    public void run() {
        try {
            blockedQueue.review(student,book.get(0));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}