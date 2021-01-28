package com.assignment.library.bookOperations;

import com.assignment.library.entity.Book;

public class AddBooks implements Runnable{
    private BlockedQueue blockedQueue;
    private String name[];
    private int id[];
    private String ISBN[];
    private Boolean isOwned[];
    private Boolean isInCart[];

    public AddBooks(BlockedQueue blockedQueue, String[] name, int[] id, String[] ISBN, Boolean[] isOwned, Boolean[] isInCart) {
        super();
        this.blockedQueue = blockedQueue;
        this.name = name;
        this.id = id;
        this.ISBN = ISBN;
        this.isOwned = isOwned;
        this.isInCart = isInCart;
    }

    @Override
    public void run() {
        for(int i=0;i<id.length;i++) {
            Book b = new Book(this.name[i], this.id[i], this.ISBN[i],"Library",this.isOwned[i], this.isInCart[i]);
            try {
                blockedQueue.put(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
