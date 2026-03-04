package com.example.oop2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateClassRoomRequest {
    private Integer classNumber;
    private String type;
    private Integer size;
    private boolean available;

}
