package com.example.oop2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGradeRequest {
    private String courseName;
    private Double grade;
}