package com.example.oop2.services;

import com.example.oop2.dtos.CreateClassRoomRequest;
import com.example.oop2.entities.ClassRoom;

import java.util.List;

public interface IClassRoomService {

    ClassRoom create(CreateClassRoomRequest request);
    List<ClassRoom> getAll();
    ClassRoom getById(Long id);
    void delete(Long id);
}