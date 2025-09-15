package com.sanket.day6_combined_api.service;

import com.sanket.day6_combined_api.entity.Course;
import com.sanket.day6_combined_api.entity.Student;
import com.sanket.day6_combined_api.exception.ResourceNotFoundException;
import com.sanket.day6_combined_api.repository.CourseRepository;
import com.sanket.day6_combined_api.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public List<Student> getAll() { return studentRepo.findAll(); }

    public Student getById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    public Student create(Student s) {
        return studentRepo.save(s);
    }

    public Student update(Long id, Student updated) {
        Student s = getById(id);
        s.setName(updated.getName());
        s.setAge(updated.getAge());
        s.setEmail(updated.getEmail());
        s.setMobileNumber(updated.getMobileNumber());
        s.setSection(updated.getSection());
        return studentRepo.save(s);
    }

    public void delete(Long id) { studentRepo.deleteById(id); }

    @Transactional
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Student s = getById(studentId);
        Course c = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", courseId));
        s.getCourses().add(c);
        c.getStudents().add(s);
        // since we are in a transaction and using managed entities, save is optional
        studentRepo.save(s);
        courseRepo.save(c);
    }

    public Set<Course> getCoursesForStudent(Long studentId) {
        Student s = getById(studentId);
        return s.getCourses();
    }
}
