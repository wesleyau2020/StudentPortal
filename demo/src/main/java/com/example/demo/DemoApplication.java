package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public List<Student> hello() {
		Student newStudent = new Student(
				"John Doe",
				"JohnDoe@email.com",
				LocalDate.of(2000, Month.OCTOBER, 10),
				22);
		return List.of(newStudent);
	}

	// @GetMapping
	// public String hello() {
	// return "Hello World";
	// }

}
