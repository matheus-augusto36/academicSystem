package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.Teacher;
import com.matteo.academicSystem.services.TeacherService;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherResource {
	
	@Autowired
	private TeacherService service;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll() {
		List<Teacher> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable("id") Long id) {
		Teacher obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
