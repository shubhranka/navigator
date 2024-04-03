package com.shubhlranka.navigator.controllers;

import com.shubhlranka.navigator.dto.CreateExamDto;
import com.shubhlranka.navigator.entities.Exam;
import com.shubhlranka.navigator.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

    @Autowired
    private ExamService examService;
    @PostMapping("/exam")
    public String createExam(@RequestBody CreateExamDto createExamDto) {
        Exam exam = examService.createExam(createExamDto);
        return "Exam created with id: " + exam.getId();
    }

1
}
