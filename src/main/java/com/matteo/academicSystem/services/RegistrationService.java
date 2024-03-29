package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.repositories.RegistrationRepository;
import com.matteo.academicSystem.services.exceptions.DatabaseException;
import com.matteo.academicSystem.services.exceptions.ResourceNotFoundException;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repository;
	
	public List<Registration> findAll() {
		return repository.findAll();
	}
	
	public Registration findById(Long id) {
		Optional<Registration> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Registration insert(Registration obj) {
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
	
	public Registration update(Long id, Registration obj) {
		try {
			Registration entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Registration entity, Registration obj) {
		entity.setStudent(obj.getStudent());
		entity.setCourseClass(obj.getCourseClass());
	}
}
