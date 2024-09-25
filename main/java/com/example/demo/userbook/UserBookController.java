package com.example.demo.userbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/userbook")
public class UserBookController {
    private final UserBookService userBookService;

    @Autowired
    public UserBookController(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    @GetMapping
    public List<UserBook> getUserBooks() {
        return userBookService.getUserBooks();
    }

    @PostMapping
    public void registerNewUserBook(@RequestBody UserBook userBook) {
        userBookService.addNewUserBook(userBook);
    }

    @DeleteMapping(path = "{userBookId}")
    public void deleteUser(@PathVariable("userBookId") Long userBookId) {
        userBookService.deleteUserBook(userBookId);
    }

    @PutMapping(path = "{userBookId}")
    public void updateUser(@PathVariable("userBookId") Long userBookId) {
        userBookService.updateUserBook(userBookId);
    }
}
