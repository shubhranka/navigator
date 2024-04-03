package com.shubhlranka.navigator.services;

import com.shubhlranka.navigator.dto.CreateSubjectDto;
import com.shubhlranka.navigator.entities.Subject;
import com.shubhlranka.navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject findById(Long subjectId) {
        System.out.println("Subject ID: " + subjectId);
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public Subject createSubject(CreateSubjectDto createSubjectDto) {
        Subject subject = new Subject();
        subject.setName(createSubjectDto.getName());
        return subjectRepository.save(subject);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public void updateSubject(Long subjectId, CreateSubjectDto createSubjectDto) {
        Subject subject = subjectRepository.findById(subjectId).
                orElseThrow(() -> new RuntimeException("Subject not found"));
        subject.setName(createSubjectDto.getName());
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
