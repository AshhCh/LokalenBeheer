package com.example.oop2.controllers;

import com.example.oop2.entities.GradeRecord;
import com.example.oop2.services.serviceImpl.GradeRecordServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/grades")
public class GradeRecordController {

    private final GradeRecordServiceImpl gradeRecordService; // depends on interface

    public GradeRecordController(GradeRecordServiceImpl gradeRecordService) {
        this.gradeRecordService = gradeRecordService;
    }

    @GetMapping
    public List<GradeRecord> getAll() {
        return gradeRecordService.getAll();
    }

    @GetMapping("/{id}")
    public GradeRecord getById(@PathVariable Long id) {
        return gradeRecordService.getById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<GradeRecord> getByStudent(@PathVariable Long studentId) {
        return gradeRecordService.getByStudentId(studentId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        gradeRecordService.delete(id);
    }
}

