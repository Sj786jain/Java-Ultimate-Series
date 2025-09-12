package com.sanket.day3_student_management_api.service;

import com.sanket.day3_student_management_api.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentById(int id){
//        for(Student student: students){
//            if(student.getId()==id){
//                return student;
//            }
//        }
//        return null;

//        Using Stream
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public Student addStudent(Student student){
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public Student updateStudent(int id, Student updatedStudent){
        for(Student s : students){
            if(s.getId() == id){
                s.setName(updatedStudent.getName());
                s.setAge(updatedStudent.getAge());
                s.setEmail(updatedStudent.getEmail());
                s.setMobileNumber(updatedStudent.getMobileNumber());
                s.setSection(updatedStudent.getSection());
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id){
        return students.removeIf(s->s.getId()==id);
    }

    public List<Student> searchByName(String name){
        List<Student> result = new ArrayList<>();
        for(Student s : students){
            if(s.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(s);
            }
        }
        return result;
    }



}
