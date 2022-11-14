package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
