package com.assignment.library.bookOperations;

import com.assignment.library.entity.Book;
import java.util.ArrayList;

public class BooksList {
    private ArrayList<Book> BooksList;

    BooksList(ArrayList<Book> BooksList){
        this.BooksList = BooksList;
    }

    public ArrayList<Book> getBooksList() {
        return BooksList;
    }

    public void setList(ArrayList<Book> BooksList) {
        this.BooksList = BooksList;
    }

    public void appendList(ArrayList<Book> BooksList) {
        this.BooksList.addAll(BooksList);
    }
    public void addBook(Book book) {
        this.BooksList.add(book);
    }
    public void listAll() {
        System.out.println("ID\tName\tISBN\tReviewer\tisInReview");
        for(Book b : this.BooksList) {
            System.out.println(b.getId() + "\t" + b.getName()+ "\t" + b.getISBN()+ "\t" + b.getReviewer()+ "\t" + b.getInReview() + "\t" + b.getInCart());
        }
    }

    public int length() {
        return this.BooksList.size();
    }
}
