package com.example.oop2.services.serviceImpl;

import com.example.oop2.dtos.CreateStudentRequest;
import com.example.oop2.entities.GradeRecord;
import com.example.oop2.entities.Student;
import com.example.oop2.repositories.StudentRepository;
import com.example.oop2.services.IGradeRecordService;
import com.example.oop2.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final IGradeRecordService gradeRecordService;

    public StudentServiceImpl(StudentRepository studentRepository,
                              IGradeRecordService gradeRecordService) {
        this.studentRepository = studentRepository;
        this.gradeRecordService = gradeRecordService;
    }

    @Override
    public Student create(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }


    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student not found with id: " + id
                        )
                );
    }

    @Override
    public void delete(Long id) {
        Student student = getById(id);
        studentRepository.delete(student);
    }

    /**
     * StudentService coordinates the use case, but GradeRecordService owns
     * grade validation and persistence.
     */
    @Override
    public GradeRecord addGrade(Long studentId, String courseName, Double grade) {
        Student student = getById(studentId);
        return gradeRecordService.createForStudent(student, courseName, grade);
    }
}
