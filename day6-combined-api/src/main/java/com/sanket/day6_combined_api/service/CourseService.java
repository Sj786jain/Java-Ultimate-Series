package com.sanket.day6_combined_api.service;

import com.sanket.day6_combined_api.entity.Course;
import com.sanket.day6_combined_api.entity.Student;
import com.sanket.day6_combined_api.exception.ResourceNotFoundException;
import com.sanket.day6_combined_api.repository.CourseRepository;
import com.sanket.day6_combined_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepo;
    private final StudentRepository studentRepo;

    public CourseService(CourseRepository courseRepo, StudentRepository studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    public List<Course> getAll() { return courseRepo.findAll(); }

    public Course getById(Long id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
    }

    public Course create(Course c) { return courseRepo.save(c); }

    public Course update(Long id, Course updated) {
        Course c = getById(id);
        c.setName(updated.getName());
        c.setDescription(updated.getDescription());
        return courseRepo.save(c);
    }

    public void delete(Long id) { courseRepo.deleteById(id); }

    public Set<Student> getStudentsForCourse(Long courseId) {
        Course c = getById(courseId);
        return c.getStudents();
    }
}
