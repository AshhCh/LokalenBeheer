package com.example.oop2.services.serviceImpl;

import com.example.oop2.entities.Classroom;
import com.example.oop2.repositories.ClassroomRepository;
import com.example.oop2.services.ClassroomService;
import com.example.oop2.dtos.CreateClassroomRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements IClassRoomService {

    private final ClassRoomRepository ClassRoomRepository;

    public ClassRoomServiceImpl(ClassRoomRepository ClassRoomRepository) {
        this.ClassRoomRepository = ClassRoomRepository;
    }

    @Override
    public ClassRoom create(CreateClassRoomRequest request) {
        Classroom classroom = new Classroom();
        classroom.setClassroomNumber(request.getClassroomNumber());
        classroom.setType(request.getType());
        classroom.setSize(request.getSize());
        classroom.setAvailable(request.isAvailable());
        return classroomRepository.save(classroom);
    }

    @Override
    public GradeRecord getById(Long id) {
        return gradeRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "GradeRecord not found with id: " + id));
    }

    @Override
    public List<ClassRoom> getAll() {
        return ClassRoomRepository.findAll();}

    @Override
    public List<ClassRoom> getAllClassrooms() {
        return ClassRoomRepository.findAll();
    }
}
