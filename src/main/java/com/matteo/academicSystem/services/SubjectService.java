package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.CourseClass;
import com.matteo.academicSystem.entities.Subject;
import com.matteo.academicSystem.repositories.SubjectRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

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
	
	public Subject insert(Subject entity) {
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
	
	public Subject update(Long id, Subject obj) {
		try {
			Subject entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Subject entity, Subject obj) {
		entity.setDescription(obj.getDescription());
		entity.setMinimumScore(obj.getMinimumScore());
		entity.setName(obj.getName());
		entity.setTeacher(obj.getTeacher());
	}
	

}
