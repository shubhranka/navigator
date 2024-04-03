package com.shubhlranka.navigator.eventhandlers;

import com.shubhlranka.navigator.entities.Exam;
import com.shubhlranka.navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Exam.class)
public class ExamEventHandler {

    @Autowired
    private SubjectRepository subjectRepository;
    @HandleBeforeCreate
    public void handleExamBeforeCreate(Exam exam) {
        long subjectId = exam.getSubject().getId();
        System.out.println("Subject ID: " + subjectId);
    }
}
