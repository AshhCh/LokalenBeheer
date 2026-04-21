package com.example.oop2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String courseName;


    //Koppeling naar Students
    @ManyToOne
    @JsonIgnore
    private Student student;

    //Koppeling naar ClassRoom
    @ManyToOne
    @JsonIgnore
    private ClassRoom classRoom;

    private LocalDateTime beginTijd;  // bv. 2025-04-20T09:00
    private LocalDateTime eindTijd;   // bv. 2025-04-20T11:00

    @Enumerated(EnumType.STRING)
    private ReservationStutus status; //actief, geanuleerd

    public Reservation() {}

}
