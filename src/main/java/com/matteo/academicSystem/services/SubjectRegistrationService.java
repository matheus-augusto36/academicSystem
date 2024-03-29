package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.CourseClass;
import com.matteo.academicSystem.entities.SubjectRegistration;
import com.matteo.academicSystem.repositories.SubjectRegistrationRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class SubjectRegistrationService {

	@Autowired
	private SubjectRegistrationRepository repository;
	
	public List<SubjectRegistration> findAll() {
		return repository.findAll();
	}
	
	public SubjectRegistration findById(Long id) {
		Optional<SubjectRegistration> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public SubjectRegistration insert(SubjectRegistration entity) {
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
	
	public SubjectRegistration update(Long id, SubjectRegistration obj) {
		try {
			SubjectRegistration entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(SubjectRegistration entity, SubjectRegistration obj) {
		entity.setCourse(obj.getCourse());
		entity.setSubject(obj.getSubject());
	}
}
