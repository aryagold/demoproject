package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
        return args -> {
            Users mariam = new Users(
                                "Mariam",
                                "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
                        );
            Users alex = new Users(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, JANUARY, 5)
            );

            userRepository.saveAll(List.of(mariam, alex));
        };
    }
}
