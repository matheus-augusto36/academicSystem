package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
