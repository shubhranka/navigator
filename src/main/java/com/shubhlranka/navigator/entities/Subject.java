package com.shubhlranka.navigator.entities;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Subject name is mandatory")
    @Column(unique = true)
    private String name;

    @ManyToMany
    @JsonIncludeProperties("id")
    private List<Student> students;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIncludeProperties("id")
    private List<Exam> exams;
}
