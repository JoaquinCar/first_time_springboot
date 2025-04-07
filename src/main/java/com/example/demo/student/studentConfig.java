package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {
    // This class is used to configure the student service and repository
    // It is annotated with @Configuration to indicate that it is a configuration class
    @Bean // This annotation indicates that this method will return a bean that should be managed by the Spring container
    CommandLineRunner commandLineRunner(studentRepository repository) {
         // This method is used to run some code at startup
        return args -> {
            student kino = new  student(
                    "Kino",
                    "kino@gmail.com",
                    LocalDate.of(2000, Month.JUNE,10));

            student jorge = new  student(
                    "Jorge",
                    "Flowers@gmail.com",
                    LocalDate.of(2006, Month.MAY,10)

            );
            repository.saveAll(
                    List.of(kino, jorge) // This method saves the list of students to the database
            );
        };


        }
    }

