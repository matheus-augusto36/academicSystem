package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Course;
import com.matteo.academicSystem.repositories.CourseRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll() {
		return repository.findAll();
	}
	
	public Course findById(Long id) {
		Optional<Course> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Course insert(Course entity) {
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Course update(Long id, Course obj) {
		try {
			Course entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Course entity, Course obj) {
		entity.setName(obj.getName());
		entity.setSemesters(obj.getSemesters());
		entity.setPrice(obj.getPrice());
	}
}
