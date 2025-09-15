package com.sanket.day6_combined_api.controller;

import com.sanket.day6_combined_api.entity.Course;
import com.sanket.day6_combined_api.entity.Student;
import com.sanket.day6_combined_api.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin("*")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) { this.service = service; }

    @GetMapping
    public List<Course> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Course create(@RequestBody Course c) { return service.create(c); }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course c) { return service.update(id, c); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/{courseId}/students")
    public Set<Student> getStudents(@PathVariable Long courseId) {
        return service.getStudentsForCourse(courseId);
    }
}
