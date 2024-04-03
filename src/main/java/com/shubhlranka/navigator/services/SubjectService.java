package com.shubhlranka.navigator.services;

import com.shubhlranka.navigator.entities.Subject;
import com.shubhlranka.navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject findById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }
}
