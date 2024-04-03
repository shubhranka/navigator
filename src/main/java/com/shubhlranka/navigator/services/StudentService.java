package com.shubhlranka.navigator.services;


import com.shubhlranka.navigator.NavigatorException;
import com.shubhlranka.navigator.dto.CreateStudentDto;
import com.shubhlranka.navigator.entities.Student;
import com.shubhlranka.navigator.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        if(createStudentDto.getName() == null || createStudentDto.getName().isEmpty()) {
            throw new NavigatorException("Name cannot be empty", HttpStatus.BAD_REQUEST);
        }
        student.setName(createStudentDto.getName());

        student = studentRepository.save(student);

        return student;
    }

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void updateStudent(Long studentId, CreateStudentDto createStudentDto) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new NavigatorException("Student not found", HttpStatus.NOT_FOUND);
        }
        student.setName(createStudentDto.getName());
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
