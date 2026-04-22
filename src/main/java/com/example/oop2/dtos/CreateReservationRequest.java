package com.example.oop2.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateReservationRequest {
    private Long studentId;
    private Long classRoomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}