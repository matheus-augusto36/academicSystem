package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.StudentTest;
import com.matteo.academicSystem.repositories.StudentTestRepository;

@Service
public class StudentTestService {
	
	@Autowired
	private StudentTestRepository repository;
	
	public List<StudentTest> findAll() {
		return repository.findAll();
	}
	
	public StudentTest findById(Long id) {
		Optional<StudentTest> obj = repository.findById(id);
		return obj.get();
	}
}
