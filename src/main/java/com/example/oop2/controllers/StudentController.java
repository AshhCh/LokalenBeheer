package com.example.oop2.controllers;

import com.example.oop2.dtos.CreateGradeRequest;
import com.example.oop2.dtos.CreateStudentRequest;
import com.example.oop2.entities.GradeRecord;
import com.example.oop2.entities.Student;
import com.example.oop2.services.serviceImpl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //THIS IS THE REST API REQUESTS ALLES MET @
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentServiceImpl studentService; // THIS IS THE INTERFACE depends on interface

    //CONSTRUCTOR INJECTION : CREATES STUDENSERVICEIMPL AND IMPL IT HERE (“Hey Spring, give me the StudentService when this controller starts.”)
    public StudentController(StudentServiceImpl studentService)
    {
        this.studentService = studentService;
    }

    //CREATE STUDENT (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody CreateStudentRequest request) {
        return studentService.create(request);
    }

    //GET ALL STUDENTS(GET) AUTOMATICALLY CONVERTS TO JSON
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }


    //GET STUDENT BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    //DELETE STUDENT BY ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    //ADD GRADE TO A STUDENT
    @PostMapping("/{id}/grades")
    @ResponseStatus(HttpStatus.CREATED)
    public GradeRecord addGrade(@PathVariable Long id, @RequestBody CreateGradeRequest request) {
        return studentService.addGrade(id, request.getCourseName(), request.getGrade());
    }
}

