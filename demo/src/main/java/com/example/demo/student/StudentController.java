package com.example.demo.student;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
// @CrossOrigin(origins = "http://localhost:8080")
public class StudentController {

    private final StudentService studentService;

    // @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public Student updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return studentService.updateStudent(studentId, name, email);
    }

    // @PutMapping(path = "{studentId}")
    // public Student updateStudent(
    // @PathVariable("studentId") Long studentId,
    // @RequestBody Student student) {
    // return studentService.updateStudent(studentId, student);
    // }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }
}
