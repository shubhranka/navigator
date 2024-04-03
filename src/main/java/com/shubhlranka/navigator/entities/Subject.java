package com.shubhlranka.navigator.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {

    @Id
    private long id;

    @NotBlank(message = "Subject name is mandatory")
    @UniqueElements
    private String name;

    @ManyToMany
    private List<Student> students;

    @OneToMany
    private List<Exam> exams;
}