package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.repositories.RegistrationRepository;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repository;
	
	public List<Registration> findAll() {
		return repository.findAll();
	}
	
	public Registration findById(Long id) {
		Optional<Registration> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
