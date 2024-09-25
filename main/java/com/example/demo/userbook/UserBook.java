package com.example.demo.userbook;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class UserBook {
    public static int RELATIONSHIP_WANT_TO_READ = 1;
    public static int RELATIONSHIP_READING = 2;
    public static int RELATIONSHIP_READ = 3;

    @Id
    @SequenceGenerator(
            name="userbook_sequence",
            sequenceName = "userbook_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userbook_sequence"
    )

    private long id;
    private long userId;
    private long bookId;
    private int relationship;
    private String review;
    private double rating;
    private LocalDate statusDate;

    public UserBook(long id, long userId, long bookId, int relationship, String review, double rating, LocalDate statusDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.relationship = relationship;
        this.review = review;
        this.rating = rating;
        this.statusDate = statusDate;
    }

    public UserBook(long userId, long bookId, int relationship, String review, double rating, LocalDate statusDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.relationship = relationship;
        this.review = review;
        this.rating = rating;
        this.statusDate = statusDate;
    }

    public UserBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
