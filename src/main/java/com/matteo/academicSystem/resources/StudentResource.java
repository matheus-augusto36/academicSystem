package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll() {
		List<Student> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
		Student obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
