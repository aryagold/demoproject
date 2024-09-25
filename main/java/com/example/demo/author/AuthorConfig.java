package com.example.demo.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JULY;

@Configuration
public class AuthorConfig {
    @Bean
    CommandLineRunner authorCommandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            Author claire = new Author(
                    "Claire",
                    "",
                    "Mackintosh",
                    "born in england",
                                LocalDate.of(1970, Month.DECEMBER, 5)
            );
            Author theDrift = new Author(
                        "Adam",
                    "",
                    "Nevill",
                    "writes scary books",
                    LocalDate.of(1987, Month.SEPTEMBER, 3)
            );
            authorRepository.saveAll(List.of(claire, theDrift));
        };
    }
}
