package com.example.oop2.services;

import com.example.oop2.entities.GradeRecord;
import com.example.oop2.entities.Student;

import java.util.List;

public interface IGradeRecordService {
    GradeRecord createForStudent(Student student, String courseName, Double grade);

    GradeRecord getById(Long id);

    List<GradeRecord> getAll();

    List<GradeRecord> getByStudentId(Long studentId);

    void delete(Long id);
}
