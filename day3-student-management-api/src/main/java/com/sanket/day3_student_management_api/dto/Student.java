package com.sanket.day3_student_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private int age;
    private String email;
    private long mobileNumber;
    private String section;

    public void add(Student student) {
    }
}
