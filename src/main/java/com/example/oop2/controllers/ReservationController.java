package com.example.oop2.controllers;

import com.example.oop2.dtos.CreateReservationRequest;
import com.example.oop2.entities.Reservation;
import com.example.oop2.services.serviceImpl.ReservationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody CreateReservationRequest request) {
        return reservationService.create(request);
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Long id) {
        return reservationService.getById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Reservation> getByStudent(@PathVariable Long studentId) {
        return reservationService.getByStudentId(studentId);
    }

    @GetMapping("/classroom/{classRoomId}")
    public List<Reservation> getByClassRoom(@PathVariable Long classRoomId) {
        return reservationService.getByClassRoomId(classRoomId);
    }

    @PatchMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable Long id) {
        reservationService.cancel(id);
    }
}