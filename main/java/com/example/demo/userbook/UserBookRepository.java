package com.example.demo.userbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    @Query("SELECT u FROM UserBook u WHERE u.id = ?1")
    Optional<UserBook> findUserBookById(long id);
}
