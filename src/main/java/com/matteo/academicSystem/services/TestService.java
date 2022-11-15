package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Test;
import com.matteo.academicSystem.repositories.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository repository;
	
	public List<Test> findAll() {
		return repository.findAll();
	}
	
	public Test findById(Long id) {
		Optional<Test> obj = repository.findById(id);
		return obj.get();
	}
}
