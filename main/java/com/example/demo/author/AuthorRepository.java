package com.example.demo.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

    @Query("SELECT a FROM Author a WHERE a.firstName = ?1")
    Optional<Author> findAuthorByFirstName(String firstName);
}
