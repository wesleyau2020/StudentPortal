package com.example.demo.grade;

import com.example.demo.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Student scores for SA1
    private int engScore;
    private int mathScore;
    private int sciScore;
    private int chiScore;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Grade() {
    }

    public int getEngScore() {
        return engScore;
    }

    public Grade(int engScore, int mathScore, int sciScore, int chiScore) {
        this.engScore = engScore;
        this.mathScore = mathScore;
        this.sciScore = sciScore;
        this.chiScore = chiScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getSciScore() {
        return sciScore;
    }

    public void setSciScore(int sciScore) {
        this.sciScore = sciScore;
    }

    public int getChiScore() {
        return chiScore;
    }

    public void setChiScore(int chiScore) {
        this.chiScore = chiScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
