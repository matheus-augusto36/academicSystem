package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
