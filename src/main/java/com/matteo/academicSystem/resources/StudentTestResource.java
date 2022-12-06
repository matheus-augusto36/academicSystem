package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.StudentTest;
import com.matteo.academicSystem.services.StudentTestService;

@RestController
@RequestMapping(value = "/student_tests")
public class StudentTestResource {
	
	@Autowired
	private StudentTestService service;
	
	@GetMapping
	public ResponseEntity<List<StudentTest>> findAll() {
		List<StudentTest> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentTest> findById(@PathVariable("id") Long id) {
		StudentTest obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
