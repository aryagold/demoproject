package com.example.demo.userbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class UserBookConfig {
    @Bean
    CommandLineRunner userBookCommandLineRunner(UserBookRepository userBookRepository) {
        return args -> {
            UserBook aryaBook = new UserBook(
                    1,
                    1,
                    3,
                    "Wild",
                    3.78,
                    LocalDate.of(2024, Month.MARCH, 3)
            );
            UserBook aryaBook2 = new UserBook(
                    1,
                    2,
                    3,
                    "So crazy",
                    4.34,
                    LocalDate.of(2023, Month.NOVEMBER, 4)
            );

            userBookRepository.saveAll(List.of(aryaBook, aryaBook2));
        };
    }
}
