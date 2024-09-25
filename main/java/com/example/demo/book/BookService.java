package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> userOptional = bookRepository.findBookByName(book.getName());

        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException("book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);

    }

    @Transactional
    public void updateBook(Long bookId, String name) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("book with id " + bookId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(book.getName(), name)) {
            book.setName(name);
        }
    }
}
