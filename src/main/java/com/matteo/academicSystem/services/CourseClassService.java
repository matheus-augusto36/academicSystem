package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.CourseClass;
import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.repositories.CourseClassRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class CourseClassService {
	
	@Autowired
	private CourseClassRepository repository;
	
	public List<CourseClass> findAll() {
		return repository.findAll();
	}
	
	public CourseClass findById(Long id) {
		Optional<CourseClass> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public CourseClass insert(CourseClass entity) {
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
	
	public CourseClass update(Long id, CourseClass obj) {
		try {
			CourseClass entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(CourseClass entity, CourseClass obj) {
		entity.setNumber(obj.getNumber());
		entity.setVacancies(obj.getVacancies());
		entity.setStartDate(obj.getStartDate());
	}
}
