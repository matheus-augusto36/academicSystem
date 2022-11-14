package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
