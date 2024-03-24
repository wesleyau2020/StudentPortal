package com.example.demo.grade;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@Service
public class GradeService {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    // @Autowired
    public GradeService(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    public Grade getGradesByStudentId(Long studentId) {
        // Find the student by ID
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));

        // Retrieve the grades for the student
        return gradeRepository.findByStudentId(studentId);
    }

}
