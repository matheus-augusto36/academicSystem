package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
