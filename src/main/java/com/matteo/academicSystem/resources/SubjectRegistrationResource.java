package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.SubjectRegistration;
import com.matteo.academicSystem.services.SubjectRegistrationService;

@RestController
@RequestMapping(value = "/subject_registrations")
public class SubjectRegistrationResource {

	@Autowired
	private SubjectRegistrationService service;
	
	@GetMapping
	public ResponseEntity<List<SubjectRegistration>> findAll() {
		List<SubjectRegistration> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SubjectRegistration> findById(@PathVariable("id") Long id) {
		SubjectRegistration obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
