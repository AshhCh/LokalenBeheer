//Bussiness logic
//example : the manager
package com.example.oop2.services.serviceImpl;

import com.example.oop2.entities.ClassRoom;
import com.example.oop2.repositories.ClassRoomRepository;
import com.example.oop2.services.IClassRoomService;
import com.example.oop2.dtos.CreateClassRoomRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public ClassRoom getById(Long id){
        return ClassRoomRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Classroom not found with id: " + id
                        )
                );
    }

    @Override
    public void delete(Long id){
        ClassRoom classRoom = getById(id);
        ClassRoomRepository.delete(classRoom);
    }

}
