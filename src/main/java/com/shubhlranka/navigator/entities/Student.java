package com.shubhlranka.navigator.entities;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Nonnull
    private String name;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    @JsonIncludeProperties("id")
    private List<Subject> subjects;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    @JsonIncludeProperties("id")
    private List<Exam> exams;

}
