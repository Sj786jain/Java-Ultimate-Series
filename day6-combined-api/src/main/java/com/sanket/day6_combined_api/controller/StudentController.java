package com.sanket.day6_combined_api.controller;

import com.sanket.day6_combined_api.entity.Course;
import com.sanket.day6_combined_api.entity.Student;
import com.sanket.day6_combined_api.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin("*")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @GetMapping
    public List<Student> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Student create(@RequestBody Student s) { return service.create(s); }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) { return service.update(id, s); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public void enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        service.enrollStudentInCourse(studentId, courseId);
    }

    @GetMapping("/{studentId}/courses")
    public Set<Course> getCourses(@PathVariable Long studentId) {
        return service.getCoursesForStudent(studentId);
    }
}
