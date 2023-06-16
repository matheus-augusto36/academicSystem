package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Teacher;
import com.matteo.academicSystem.repositories.TeacherRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
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
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Teacher update(Long id, Teacher obj) {
		try {
			Teacher entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Teacher entity, Teacher obj) {
		entity.setCpf(obj.getCpf());
		entity.setName(obj.getName());	
	}
	
}
