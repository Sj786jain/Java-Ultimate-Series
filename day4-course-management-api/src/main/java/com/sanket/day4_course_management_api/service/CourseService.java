package com.sanket.day4_course_management_api.service;

import com.sanket.day4_course_management_api.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();
    private int nextId = 1;

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course addCourse(Course course) {
        course.setId(nextId++);
        courses.add(course);
        return course;
    }

    public Course updateCourse(int id, Course updatedCourse) {
        for (Course c : courses) {
            if (c.getId() == id) {
                c.setName(updatedCourse.getName());
                c.setDescription(updatedCourse.getDescription());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getId() == id);
    }
}


