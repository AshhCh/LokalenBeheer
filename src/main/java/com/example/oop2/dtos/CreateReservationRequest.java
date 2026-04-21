package com.example.oop2.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateReservationRequest {
    private String courseName;

    private String firstName;
    private String lastName;
    private String email;

    private String roomNumber;
    private String type;
    private Integer size;
    private boolean available;

    private LocalDateTime beginTijd;
    private LocalDateTime eindTijd;
}