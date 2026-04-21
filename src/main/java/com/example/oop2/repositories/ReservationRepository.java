package com.example.oop2.repositories;

import com.example.oop2.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //reservering van een student
    List<Reservation> findByStudentId(Long studentId);

    //alle reservering van een lokaal
    List<Reservation> findByClassRoomId(Long classRoomId);

}
