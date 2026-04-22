package com.example.oop2.services;

import com.example.oop2.dtos.CreateReservationRequest;
import com.example.oop2.entities.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation create(CreateReservationRequest request);

    Reservation getById(Long id);

    List<Reservation> getAll();

    List<Reservation> getByStudentId(Long studentId);

    List<Reservation> getByClassRoomId(Long classRoomId);

    void cancel(Long id);
}