package com.example.demo.userbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserBookService {
    private final UserBookRepository userBookRepository;

    @Autowired
    public UserBookService(UserBookRepository userBookRepository) {
        this.userBookRepository = userBookRepository;
    }

    public List<UserBook> getUserBooks() {
        return userBookRepository.findAll();
    }

    public void addNewUserBook(UserBook userBook) {
        Optional<UserBook> userOptional = userBookRepository.findUserBookById(userBook.getId());

        userBookRepository.save(userBook);
    }

    public void deleteUserBook(Long userBookId) {
        boolean exists = userBookRepository.existsById(userBookId);
        if(!exists) {
            throw new IllegalStateException("userbook with id " + userBookId + " does not exist");
        }
        userBookRepository.deleteById(userBookId);

    }

    @Transactional
    public void updateUserBook(Long userBookId) {
        UserBook userBook = userBookRepository.findById(userBookId).orElseThrow(() -> new IllegalStateException("userbook with id " + userBookId + " does not exist"));
    }
}
