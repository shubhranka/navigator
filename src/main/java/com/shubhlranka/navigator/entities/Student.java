package com.shubhlranka.navigator.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    private long id;

    @Nonnull
    private String name;

    @ManyToMany
    private List<Subject> subjects;

    @ManyToMany
    private List<Exam> exams;

}
