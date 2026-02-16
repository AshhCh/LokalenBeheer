
//DTO'S ARE NOT DATABASE TABLES DT0'S ARE FOR JSON FILES

package com.example.oop2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
}

