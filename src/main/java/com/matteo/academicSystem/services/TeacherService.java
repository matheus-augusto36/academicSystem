package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Teacher;
import com.matteo.academicSystem.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> findAll() {
		return repository.findAll();
	}
	
	public Teacher findById(Long id) {
		Optional<Teacher> obj = repository.findById(id);
		return obj.get();
	}
}
