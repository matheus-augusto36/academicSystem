package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.repositories.StudentRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Student insert(Student obj) {
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
	
	public Student update(Long id, Student obj) {
		Student entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Student entity, Student obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
		entity.setBirthDate(obj.getBirthDate());
	}
}
