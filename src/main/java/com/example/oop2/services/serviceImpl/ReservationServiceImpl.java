package com.example.oop2.services.serviceImpl;

import com.example.oop2.dtos.CreateReservationRequest;
import com.example.oop2.entities.*;
import com.example.oop2.repositories.ClassRoomRepository;
import com.example.oop2.repositories.ReservationRepository;
import com.example.oop2.repositories.StudentRepository;
import com.example.oop2.services.IReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  StudentRepository studentRepository,
                                  ClassRoomRepository classRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public Reservation create(CreateReservationRequest request) {

        if (request.getStudentId() == null) {
            throw new IllegalArgumentException("Student is required");
        }
        if (request.getClassRoomId() == null) {
            throw new IllegalArgumentException("ClassRoom is required");
        }
        if (request.getStartTime() == null || request.getEndTime() == null) {
            throw new IllegalArgumentException("Start and end time are required");
        }
        if (!request.getEndTime().isAfter(request.getStartTime())) {
            throw new IllegalArgumentException("End time must be after start time");
        }

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id: " + request.getStudentId()));

        ClassRoom classRoom = classRoomRepository.findById(request.getClassRoomId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "ClassRoom not found with id: " + request.getClassRoomId()));

        if (!classRoom.isAvailable()) {
            throw new IllegalArgumentException("ClassRoom is not available");
        }

        List<Reservation> conflicts = reservationRepository.findConflicting(
                request.getClassRoomId(),
                request.getStartTime(),
                request.getEndTime()
        );

        if (!conflicts.isEmpty()) {
            throw new IllegalArgumentException(
                    "ClassRoom is already booked for this time slot");
        }

        Reservation reservation = new Reservation();
        reservation.setStudent(student);
        reservation.setClassRoom(classRoom);
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setStatus(ReservationStatus.ACTIVE);

        classRoom.setAvailable(false);
        classRoomRepository.save(classRoom);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Reservation not found with id: " + id));
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getByStudentId(Long studentId) {
        return reservationRepository.findByStudentId(studentId);
    }

    @Override
    public List<Reservation> getByClassRoomId(Long classRoomId) {
        return reservationRepository.findByClassRoomId(classRoomId);
    }

    @Override
    public void cancel(Long id) {
        Reservation reservation = getById(id);
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);

        reservation.getClassRoom().setAvailable(true);
        classRoomRepository.save(reservation.getClassRoom());
    }
}