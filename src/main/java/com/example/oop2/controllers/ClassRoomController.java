package com.example.oop2.controllers;

import com.example.oop2.dtos.CreateClassRoomRequest;
import com.example.oop2.entities.ClassRoom;
import com.example.oop2.services.IClassRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController {

    // Note: We use the Interface here, not the Implementation!
    private final IClassRoomService classroomService;

    public ClassRoomController(IClassRoomService classroomService) {
        this.classroomService = classroomService;
    }
    // GET ALL CLASSROOMS
    @GetMapping
    public List<ClassRoom> getAll() {
        return classroomService.getAll();
    }

    @PostMapping
    public ClassRoom create(@RequestBody CreateClassRoomRequest request) {
        return classroomService.create(request);
    }

    //GET CLASSROOM BY ID


    //DELETE STUDENT BY ID
}