package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.services.RegistrationService;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationResource {

	@Autowired
	private RegistrationService service;

	@GetMapping
	public ResponseEntity<List<Registration>> findAll() {
		List<Registration> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Registration> findById(@PathVariable("id") Long id) {
		Registration obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
