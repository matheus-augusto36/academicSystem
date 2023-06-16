package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Teacher;
import com.matteo.academicSystem.repositories.TeacherRepository;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> findAll() {
		return repository.findAll();
	}
	
	public Teacher findById(Long id) {
		Optional<Teacher> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Teacher insert(Teacher entity) {
		return repository.save(entity);
	}
	
}
