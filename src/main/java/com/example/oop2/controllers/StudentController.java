package com.example.oop2.controllers;

import com.example.oop2.dtos.CreateGradeRequest;
import com.example.oop2.dtos.CreateStudentRequest;
import com.example.oop2.entities.GradeRecord;
import com.example.oop2.entities.Student;
import com.example.oop2.services.serviceImpl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentServiceImpl studentService; // depends on interface

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody CreateStudentRequest request) {
        return studentService.create(request);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PostMapping("/{id}/grades")
    @ResponseStatus(HttpStatus.CREATED)
    public GradeRecord addGrade(@PathVariable Long id, @RequestBody CreateGradeRequest request) {
        return studentService.addGrade(id, request.getCourseName(), request.getGrade());
    }
}

