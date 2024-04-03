package com.shubhlranka.navigator.controllers;

import com.shubhlranka.navigator.dto.CreateStudentDto;
import com.shubhlranka.navigator.entities.Student;
import com.shubhlranka.navigator.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public String createStudent(@RequestBody CreateStudentDto createStudentDto) {
        Student student = studentService.createStudent(createStudentDto);
        return "Student created with id: " + student.getId();
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        return studentService.findById(id);
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable("id") long id, @RequestBody CreateStudentDto createStudentDto) {
        studentService.updateStudent(id,createStudentDto);
        return "Student updated";
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return "Student deleted";
    }
}
