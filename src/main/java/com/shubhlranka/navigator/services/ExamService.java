package com.shubhlranka.navigator.services;

import com.shubhlranka.navigator.NavigatorException;
import com.shubhlranka.navigator.dto.CreateExamDto;
import com.shubhlranka.navigator.dto.EnrollStudentDto;
import com.shubhlranka.navigator.entities.Exam;
import com.shubhlranka.navigator.entities.Student;
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

    @Autowired
    private StudentService studentService;
    public Exam createExam(CreateExamDto createExamDto) {
        Exam exam = new Exam();

        Subject subject = subjectService.findById(createExamDto.getSubject_id());
        if(subject == null) {
            throw new NavigatorException("Subject not found", HttpStatus.BAD_REQUEST);
        }
        exam.setSubject(subject);
        exam = examRepository.save(exam);
        return exam;
    }

    public void deleteExam(Long examId) {
        if(!examRepository.existsById(examId)) {
            throw new NavigatorException("Exam not found", HttpStatus.BAD_REQUEST);
        }
        examRepository.deleteById(examId);
    }

    public void updateExam(Long examId, CreateExamDto createExamDto) {
        Exam exam = examRepository.findById(examId).
                orElseThrow(() -> new NavigatorException("Exam not found", HttpStatus.BAD_REQUEST));
        Subject subject = subjectService.findById(createExamDto.getSubject_id());
        if(subject == null) {
            throw new NavigatorException("Subject not found", HttpStatus.BAD_REQUEST);
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

    public void enrollStudent(Long examId, EnrollStudentDto dto) {
        Long studentId = dto.getStudent_id();
        Exam exam = examRepository.findById(examId).
                orElseThrow(() -> new NavigatorException("Exam not found", HttpStatus.BAD_REQUEST));
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new NavigatorException("Student not found", HttpStatus.BAD_REQUEST);
        }
        List<Subject> subjects = student.getSubjects();
        if(subjects == null) {
            throw new NavigatorException("Student not enrolled in any subjects", HttpStatus.BAD_REQUEST);
        }
        boolean haveSubject = false;
        for(Subject subject: subjects) {
            if(subject.getId() == exam.getSubject().getId()) {
                haveSubject = true;
                break;
            }
        }

        if(!haveSubject) {
            throw new NavigatorException("Student not enrolled in this subject", HttpStatus.BAD_REQUEST);
        }

        exam.getStudents().add(student);
        examRepository.save(exam);
    }


}
