package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.SubjectRegistration;
import com.matteo.academicSystem.repositories.SubjectRegistrationRepository;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class SubjectRegistrationService {

	@Autowired
	private SubjectRegistrationRepository repository;
	
	public List<SubjectRegistration> findAll() {
		return repository.findAll();
	}
	
	public SubjectRegistration findById(Long id) {
		Optional<SubjectRegistration> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public SubjectRegistration insert(SubjectRegistration entity) {
		return repository.save(entity);
	}
	
}
