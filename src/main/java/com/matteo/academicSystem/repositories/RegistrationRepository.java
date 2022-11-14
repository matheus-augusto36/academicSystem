package com.matteo.academicSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.academicSystem.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
