package com.sanket.day4_course_management_api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course {
    // Getters & Setters
    private int id;
    private String name;
    private String description;

    // Constructors
    public Course() {}
    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
