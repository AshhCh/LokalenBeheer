package com.example.oop2.controllers;

// Dit importeert de DTO klasse zodat je hem kan gebruiken in deze file
import com.example.oop2.dtos.CreateReservationRequest;

// Dit importeert de Reservation entity zodat je hem kan teruggeven als response
import com.example.oop2.entities.Reservation;

import com.example.oop2.services.IReservationService;
//Importeert de HttpStatus klasse zodat je statuscodes kan gebruiken zoals CREATED en NO_CONTENT

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {
    // Declareert de service variabele — final betekent dat deze nooit meer kan veranderen na de constructor
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Deze methode reageert op POST requests naar /v1/reservations
    @PostMapping
    // Stuurt HTTP statuscode 201 (Created) terug in plaats van de standaard 200 (OK)
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody CreateReservationRequest request) {
        return reservationService.create(request);
    }

    @GetMapping

    // Geeft een lijst terug van alle Reservation objecten — Spring zet dit automatisch om naar een JSON array
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
    // Geeft een lijst van reservaties terug voor 1 specifiek lokaal
    public List<Reservation> getByClassRoom(@PathVariable Long classRoomId) {
        return reservationService.getByClassRoomId(classRoomId);
    }

    @PatchMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable Long id) {
        reservationService.cancel(id);
    }
}