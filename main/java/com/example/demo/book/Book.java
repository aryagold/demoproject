package com.example.demo.book;

import com.example.demo.author.Author;
import com.example.demo.publisher.Publisher;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name="book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private long id;
    private String name;
    private LocalDate publicationDate;
    private int pageNumbers;
    private String isbn;
    //  private long publisherId;
    private String description;
    private double pointRating;
    private int noOfRatings;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "book_publisher",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private Set<Publisher> publishers = new HashSet<>();

    public Book(long id, String name, LocalDate publicationDate, int pageNumbers, String isbn, String description, double pointRating, int noOfRatings) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.pageNumbers = pageNumbers;
        this.isbn = isbn;
        this.description = description;
        this.pointRating = pointRating;
        this.noOfRatings = noOfRatings;
    }

    public Book(String name, LocalDate publicationDate, int pageNumbers, String isbn, String description, double pointRating, int noOfRatings) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.pageNumbers = pageNumbers;
        this.isbn = isbn;
        this.description = description;
        this.pointRating = pointRating;
        this.noOfRatings = noOfRatings;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPointRating() {
        return pointRating;
    }

    public void setPointRating(double pointRating) {
        this.pointRating = pointRating;
    }

    public int getNoOfRatings() {
        return noOfRatings;
    }

    public void setNoOfRatings(int noOfRatings) {
        this.noOfRatings = noOfRatings;
    }

}
