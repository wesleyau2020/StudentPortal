package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        Student newStudent = new Student(
                "John Doe",
                "JohnDoe@email.com",
                LocalDate.of(2000, Month.OCTOBER, 10),
                22);

        Student anotherNewStudent = new Student(
                "Jane Doe",
                "JaneDoe@email.com",
                LocalDate.of(2000, Month.DECEMBER, 12),
                22);
        return List.of(newStudent, anotherNewStudent);
    }

}
