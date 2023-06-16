package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Teacher;
import com.matteo.academicSystem.entities.Test;
import com.matteo.academicSystem.repositories.TestRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

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
	
	public Test insert(Test obj) {
		return repository.save(obj);
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
	
	public Test update(Long id, Test obj) {
		try {
			Test entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Test entity, Test obj) {
		entity.setClassification(obj.getClassification());
		entity.setDate(obj.getDate());
		entity.setScore(obj.getScore());
		entity.setSubject(obj.getSubject());
	}
	
}
