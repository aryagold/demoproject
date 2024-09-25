package com.example.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> userOptional = authorRepository.findAuthorByFirstName(author.getFirstName());

        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        boolean exists = authorRepository.existsById(authorId);
        if(!exists) {
            throw new IllegalStateException("author with id " + authorId + " does not exist");
        }
        authorRepository.deleteById(authorId);

    }

    @Transactional
    public void updateAuthor(Long authorId, String name) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalStateException("author with id " + authorId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(author.getFirstName(), name)) {
            author.setFirstName(name);
        }
    }
}
