package com.shubhlranka.navigator.controllers;

import com.shubhlranka.navigator.dto.CreateSubjectDto;
import com.shubhlranka.navigator.dto.EnrollStudentDto;
import com.shubhlranka.navigator.entities.Subject;
import com.shubhlranka.navigator.services.SubjectService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @PostMapping("/subject")
    public String createSubject(@RequestBody CreateSubjectDto createSubjectDto) {
        Subject subject = subjectService.createSubject(createSubjectDto);
        return "Subject created with id: " + subject.getId();
    }

    @GetMapping("/subject/{id}")
    public Subject getSubject(@PathVariable("id") long id) {
        return subjectService.findById(id);
    }

    @GetMapping("/subjects")
    public List<Subject> getSubjects() {
        return subjectService.findAll();
    }

    @PutMapping("/subject/{id}")
    public String updateSubject(@PathVariable("id") long id, @RequestBody CreateSubjectDto createSubjectDto) {
        subjectService.updateSubject(id,createSubjectDto);
        return "Subject updated";
    }

    @DeleteMapping("/subject/{id}")
    public String deleteSubject(@PathVariable("id") long id) {
        subjectService.deleteSubject(id);
        return "Subject deleted";
    }

    @PostMapping("/enroll/{subjectId}")
    public String enrollStudent(@PathVariable("subjectId") long subjectId, @RequestBody EnrollStudentDto enrollStudentDto) {
        subjectService.enrollStudent(subjectId, enrollStudentDto);
        return "Student enrolled";
    }
}
