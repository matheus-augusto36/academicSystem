package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.CourseClass;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {

}
