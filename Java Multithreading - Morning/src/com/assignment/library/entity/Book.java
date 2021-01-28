package com.assignment.library.entity;

public class Book {
    private String name;
    private int id;
    private String ISBN;
    private Boolean inReview;
    private String Reviewer;
    private Boolean inCart;

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getReviewer() {
        return Reviewer;
    }
    public Boolean getInReview() {
        return inReview;
    }
    public Boolean getInCart() {
        return inCart;
    }
    public void setInCart(Boolean isInCart) {
        this.inCart = isInCart;
    }
    public void setInReview(Boolean isInReview) {
        this.inReview = isInReview;
    }
    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }
    public Book(String name, int id, String ISBN, String Reviewer, Boolean inReview, Boolean inCart) {
        super();
        this.name = name;
        this.id = id;
        this.ISBN = ISBN;
        this.Reviewer = Reviewer;
        this.inReview = inReview;
        this.inCart = inCart;
    }

    public void getDetails() {
        System.out.println(this.getName() + "\t\t" + this.getId()+ "\t" + this.getISBN()+ "\t\t" + this.getReviewer()+ "\t\t" + this.getInReview() + "\t\t" + this.getInCart());
    }
}