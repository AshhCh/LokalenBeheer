package com.example.oop2.repositories;

import com.example.oop2.entities.Reservation;
import com.example.oop2.entities.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Later toevoegen zonder iets te breken:
    List<Reservation> findByStudentId(Long studentId);
    List<Reservation> findByClassRoomId(Long classRoomId);

    // Conflictcheck: is this classroom already booked in this timeslot?
    @Query("SELECT r FROM Reservation r WHERE r.classRoom.id = :classRoomId " +
            "AND r.status = 'ACTIVE' " +
            "AND r.startTime < :endTime " +
            "AND r.endTime > :startTime")
    List<Reservation> findConflicting(
            @Param("classRoomId") Long classRoomId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}