package com.shubhlranka.navigator.controllers;

import com.shubhlranka.navigator.dto.CreateExamDto;
import com.shubhlranka.navigator.dto.EnrollStudentDto;
import com.shubhlranka.navigator.entities.Exam;
import com.shubhlranka.navigator.services.ExamService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamService examService;
    @PostMapping("/exam")
    public String createExam(@RequestBody CreateExamDto createExamDto) {
        Exam exam = examService.createExam(createExamDto);
        return "Exam created with id: " + exam.getId();
    }

    @DeleteMapping("/exam/{id}")
    public String deleteExam(@PathVariable("id") long id) {
        examService.deleteExam(id);
        return "Exam deleted";
    }

    @PutMapping("/exam/{id}")
    public String updateExam(@PathVariable("id") long id, @RequestBody CreateExamDto createExamDto) {
        examService.updateExam(id,createExamDto);
        return "Exam updated";
    }

    @GetMapping("/exam/{id}")
    public Exam getExam(@PathVariable("id") long id) {
        return examService.findById(id);
    }

    @GetMapping("/exams")
    public List<Exam> getExams() {
        return examService.findAll();
    }

    @PostMapping("/exam/{examId}")
    public String addStudent(@PathVariable("examId") long examId, @RequestBody EnrollStudentDto enrollStudentDto) {
        examService.enrollStudent(examId, enrollStudentDto);
        return "Student added to exam";
    }

}
