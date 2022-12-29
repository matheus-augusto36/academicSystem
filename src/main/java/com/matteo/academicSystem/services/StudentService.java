package com.matteo.academicSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.get();
	}
	
	public Student insert(Student obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Student update(Long id, Student obj) {
		Student entity = repository.getReferenceById(id);
		updateData(entity, id);
		return repository.save(entity);
	}

	private void updateData(Student entity, Long id) {
		entity.setName(findById(id).getName());
		entity.setCpf(findById(id).getCpf());
		entity.setBirthDate(findById(id).getBirthDate());
	}
}
