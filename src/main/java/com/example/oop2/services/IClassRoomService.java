package com.example.oop2.services;

import com.example.oop2.dtos.CreateClassRoomRequest;
import com.example.oop2.entities.ClassRoom;
import java.util.List;

public interface IClassroomService {

    Classroom create(CreateClassroomRequest request);
    List<ClassRoom> getAll();
}