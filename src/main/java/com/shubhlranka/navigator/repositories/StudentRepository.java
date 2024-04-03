package com.shubhlranka.navigator.repositories;

import com.shubhlranka.navigator.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
