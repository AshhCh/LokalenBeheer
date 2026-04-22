package com.example.oop2.controllers;

import com.example.oop2.dtos.CreateClassRoomRequest;
import com.example.oop2.entities.ClassRoom;
import com.example.oop2.services.IClassRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/classrooms")
public class ClassRoomController {

    // Note: We use the Interface here, not the Implementation!
    private final IClassRoomService classroomService;

    //CONSTRUCTOR INJECTION
    public ClassRoomController(IClassRoomService classroomService) {
        this.classroomService = classroomService;
    }

    //CREATE CLASSROOM(POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassRoom create(@RequestBody CreateClassRoomRequest request) {
        return classroomService.create(request);
    }

    // GET ALL CLASSROOMS
    @GetMapping
    public List<ClassRoom> getAll() {
        return classroomService.getAll();
    }

    //GET CLASSROOM BY ID
    @GetMapping("/{id}")
    public ClassRoom getById(@PathVariable Long id) { return classroomService.getById(id); }

    //DELETE CLASSROOM BY ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    { classroomService.delete(id); }
}