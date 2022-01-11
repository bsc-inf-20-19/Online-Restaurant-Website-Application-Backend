package com.example.demo.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository) {
        return args -> {
           Customer mphatso = new  Customer(
                    "Mphatso",
                    "mphatsomphepo829@gmail.com",
                    LocalDate.of(2001, MAY, 3)
            );
            Customer thandie = new  Customer(
                    "Thandie",
                    "Thandie@gmail.com",
                    LocalDate.of(2002, MAY, 3)
            );

            repository.saveAll(
                    List.of(mphatso, thandie)
            );

        };
    }
}
