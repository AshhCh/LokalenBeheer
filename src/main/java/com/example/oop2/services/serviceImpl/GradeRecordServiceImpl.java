package com.example.oop2.services.serviceImpl;

import com.example.oop2.entities.GradeRecord;
import com.example.oop2.entities.Student;
import com.example.oop2.repositories.GradeRecordRepository;
import com.example.oop2.services.IGradeRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeRecordServiceImpl implements IGradeRecordService {

    private final GradeRecordRepository gradeRecordRepository;

    public GradeRecordServiceImpl(GradeRecordRepository gradeRecordRepository) {
        this.gradeRecordRepository = gradeRecordRepository;
    }

    @Override
    public GradeRecord createForStudent(Student student, String courseName, Double grade) {

        if (student == null) {
            throw new IllegalArgumentException("Student is required");
        }

        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name is required");
        }

        if (grade == null || grade < 0 || grade > 10) {
            throw new IllegalArgumentException("Grade must be between 0 and 10");
        }

        GradeRecord record = new GradeRecord();
        record.setCourseName(courseName.trim());
        record.setGrade(grade);
        record.setStudent(student);

        return gradeRecordRepository.save(record);
    }

    @Override
    public GradeRecord getById(Long id) {
        return gradeRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "GradeRecord not found with id: " + id));
    }

    @Override
    public List<GradeRecord> getAll() {
        return gradeRecordRepository.findAll();
    }

    @Override
    public List<GradeRecord> getByStudentId(Long studentId) {
        return gradeRecordRepository.findByStudentId(studentId);
    }

    @Override
    public void delete(Long id) {
        GradeRecord record = getById(id);
        gradeRecordRepository.delete(record);
    }
}
