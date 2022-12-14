package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.Test;
import com.matteo.academicSystem.services.TestService;

@RestController
@RequestMapping(value = "/tests")
public class TestResource {
	
	@Autowired
	private TestService service;

	@GetMapping
	public ResponseEntity<List<Test>> findAll() {
		List<Test> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Test> findById(@PathVariable("id") Long id) {
		Test obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
