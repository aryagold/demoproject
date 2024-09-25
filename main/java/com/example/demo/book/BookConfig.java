package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository bookRepository) {
        return args -> {
            Book drowning = new Book(
                    "Drowning",
                    LocalDate.of(2015, FEBRUARY, 6),
                    345,
                    "IHG85983234",
                    "Book about people going down in plane.",
                    3.98,
                    45673
            );
            Book theDrift = new Book(
                    "The Drift",
                    LocalDate.of(2024, JULY, 3),
                    315,
                    "IHG85856423",
                    "30 days of night from wish.",
                    4.00,
                    576
            );
            bookRepository.saveAll(List.of(drowning, theDrift));
        };
    }
}
