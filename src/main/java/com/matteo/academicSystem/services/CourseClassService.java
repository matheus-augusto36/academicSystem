package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.CourseClass;
import com.matteo.academicSystem.repositories.CourseClassRepository;

@Service
public class CourseClassService {
	
	@Autowired
	private CourseClassRepository repository;
	
	public List<CourseClass> findAll() {
		return repository.findAll();
	}
	
	public CourseClass findById(Long id) {
		Optional<CourseClass> obj = repository.findById(id);
		return obj.get();
	}
}
