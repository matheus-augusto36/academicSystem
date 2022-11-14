package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Subject;
import com.matteo.academicSystem.repositories.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository repository;
	
	public List<Subject> findAll() {
		return repository.findAll();
	}
	
	public Subject findById(Long id) {
		Optional<Subject> obj = repository.findById(id);
		return obj.get();
	}
}
