package com.example.oop2.services.serviceImpl;

import com.example.oop2.entities.ClassRoom;
import com.example.oop2.repositories.ClassRoomRepository;
import com.example.oop2.services.IClassRoomService;
import com.example.oop2.dtos.CreateClassRoomRequest;
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
        ClassRoom classroom = new ClassRoom();
        classroom.setRoomNumber(request.getRoomNumber());
        classroom.setType(request.getType());
        classroom.setSize(request.getSize());
        classroom.setAvailable(request.isAvailable());
        return ClassRoomRepository.save(classroom);
    }

    @Override
    public List<ClassRoom> getAll() {
        return ClassRoomRepository.findAll();
    }
}
