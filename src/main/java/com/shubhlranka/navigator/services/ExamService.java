package com.shubhlranka.navigator.services;

import com.shubhlranka.navigator.NavigatorException;
import com.shubhlranka.navigator.dto.CreateExamDto;
import com.shubhlranka.navigator.entities.Exam;
import com.shubhlranka.navigator.entities.Subject;
import com.shubhlranka.navigator.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ExamRepository examRepository;
    public Exam createExam(CreateExamDto createExamDto) {
        Exam exam = new Exam();

        Subject subject = subjectService.findById(createExamDto.getSubject_id());
        if(subject == null) {
            throw new NavigatorException("Subject not found", HttpStatus.NOT_FOUND);
        }
        exam.setSubject(subject);
        exam = examRepository.save(exam);
        return exam;
    }

    public void deleteExam(Long examId) {
        examRepository.deleteById(examId);
    }

    public void updateExam(Long examId, CreateExamDto createExamDto) {
        Exam exam = examRepository.findById(examId).
                orElseThrow(() -> new NavigatorException("Exam not found", HttpStatus.NOT_FOUND));
        Subject subject = subjectService.findById(createExamDto.getSubject_id());
        if(subject == null) {
            throw new NavigatorException("Subject not found", HttpStatus.NOT_FOUND);
        }
        exam.setSubject(subject);
        examRepository.save(exam);
    }

    public Exam findById(Long examId) {
        return examRepository.findById(examId).orElse(null);
    }

    public List<Exam> findAll() {
        return examRepository.findAll();
    }


}
