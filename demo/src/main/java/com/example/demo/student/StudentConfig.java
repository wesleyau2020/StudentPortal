package com.example.demo.student;

// import java.time.LocalDate;
// import java.time.Month;
// import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        // return args -> {
        // Student newStudent = new Student(
        // "John Doe",
        // "JohnDoe@email.com",
        // LocalDate.of(2000, Month.OCTOBER, 10));

        // Student anotherNewStudent = new Student(
        // "Jane Doe",
        // "JaneDoe@email.com",
        // LocalDate.of(2000, Month.DECEMBER, 12));

        // studentRepository.saveAll(List.of(newStudent, anotherNewStudent));
        // };

        return args -> {
        };
    }
}
