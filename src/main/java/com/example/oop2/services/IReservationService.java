package com.example.oop2.services;

import com.example.oop2.repositories.*;
import com.example.oop2.dtos.CreateReservationRequest;
import com.example.oop2.entities.*;
import com.example.oop2.services.ReservationServiceImpl;

import java.util.List;

public interface IReservationService {
    GradeRecord createForStudent(Student student, String courseName, Double grade);

    GradeRecord getById(Long id);

    List<GradeRecord> getAll();

    List<GradeRecord> getByStudentId(Long studentId);

    void delete(Long id);
}
