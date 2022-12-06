package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.StudentTest;

public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {

}
