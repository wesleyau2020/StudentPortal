package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    // @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (!optionalStudent.isPresent()) {
            throw new IllegalStateException("studentId: " + studentId + " does not exists");
        }

        return studentRepository.findById(studentId).orElse(null);
    }

    public Student addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());

        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Email: " + student.getEmail() + " already exists");
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("studentId: " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student updateStudent(Long studentId, Student newStudentDetails) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("studentId: " + studentId + "does not exist"));

        String name = newStudentDetails.getName();
        String email = newStudentDetails.getEmail();

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            // Optional<Student> studentOptional =
            // studentRepository.findStudentByEmail(newStudentDetails.getEmail());
            // if (studentOptional.isPresent()) {
            // throw new IllegalStateException("Email: " + newStudentDetails.getEmail() + "
            // already exists");
            // }
            student.setEmail(email);
        }

        return student;
    }

}
