package com.example.oop2.services;

import com.example.oop2.dtos.CreateStudentRequest;
import com.example.oop2.entities.GradeRecord;
import com.example.oop2.entities.Student;

import java.util.List;

public interface IStudentService {
    Student create(CreateStudentRequest request);
    List<Student> getAll();
    Student getById(Long id);
    void delete(Long id);
    GradeRecord addGrade(Long studentId, String courseName, Double grade);
}
