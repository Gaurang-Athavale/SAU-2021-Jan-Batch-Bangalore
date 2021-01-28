package com.assignment.library.bookOperations;

import com.assignment.library.entity.Book;
import com.assignment.library.entity.Student;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class BlockedQueue {
    private BooksList bookList;
    private Lock lock = new ReentrantLock();
    private Condition addBookCondition = lock.newCondition();
    private Condition buyerCondition = lock.newCondition();
    private ArrayList<Book> blockingQueue = new ArrayList<Book>();
    private int bookCount = 0;

    public BlockedQueue(){ }

    public ArrayList<Book> listBooks() {
        System.out.println("\nBooks List:\n");
        System.out.println("Name\tId\tISBN\tReviewer\tReview?\t\tBought?");
        for(Book bk: blockingQueue) {
            try {
                bk.getDetails();
            }catch (Exception e) { }
        }
        return blockingQueue;
    }

    public void removeFromCart(Student student, Book book) throws InterruptedException{
        lock.lock();
        try {
            for(int i = 0; i < blockingQueue.size(); i++) {
                if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInCart(false);
                    blockingQueue.get(i).setReviewer("Library");
                    break;
                }
            }
            addBookCondition.signalAll();
        } catch (Exception e) {  }
        finally {
            lock.unlock();
        }
    }

    public void addToCart(Student student, Book book) throws InterruptedException{
        lock.lock();
        try {
            if(student.doesOwnBook(book)) {
                System.out.println("The book is already issued by the student. You cannot issue another book :(");
                return;
            }
            for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
                if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInCart(true);
                    blockingQueue.get(i).setReviewer(student.getId() + "->" + student.getDepartment());
                    break;
                }
            }
            addBookCondition.signalAll();
        } catch (Exception e) { }
        finally {
            lock.unlock();
        }
    }

    public void put(Book book) throws InterruptedException{
        lock.lock();
        try {
            blockingQueue.add(book);
            bookCount++;
            buyerCondition.signalAll();
        } catch (Exception e) { }
        finally {
            lock.unlock();
        }
    }

    public Object review(Student student, Book book) throws InterruptedException{
        lock.lock();
        try {
            if(book == null) {
                System.out.println("Zero Books !!!");
                return null;
            }
            while(bookCount == 0) {
                buyerCondition.await();
            }
            if(student.doesOwnBook(book)) {
                System.out.println("The book is already issued by the student. You cannot issue another book :(");
                return null;
            }
            for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
                if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInReview(true);
                    blockingQueue.get(i).setReviewer(student.getId() + "->" + student.getDepartment());
                    student.addReviewBook(blockingQueue.get(i));
                    break;
                }
            }
            addBookCondition.signalAll();
            return null;
        } finally{
            lock.unlock();
        }
    }

    public Object checkout(Student student, Book book) throws InterruptedException{
        lock.lock();
        try {
            while(bookCount == 0) {
                buyerCondition.await();
            }
            if(student.doesOwnBook(book)) {
                System.out.println("The book is already issued by the student. You cannot issue another book :(");
                return null;
            }
            for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
                if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInReview(true);
                    blockingQueue.get(i).setReviewer(student.getId() + "->" + student.getDepartment());
                    student.addBoughtBook(blockingQueue.get(i));
                    blockingQueue.remove(i);
                    break;
                }
            }
            System.out.println("Thank you for buying the book !!");
            addBookCondition.signalAll();
            return null;
        } finally{
            lock.unlock();
        }
    }
}