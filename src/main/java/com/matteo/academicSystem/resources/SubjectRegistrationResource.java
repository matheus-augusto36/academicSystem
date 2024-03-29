package com.matteo.academicSystem.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matteo.academicSystem.entities.Course;
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
	
	@PostMapping
	public ResponseEntity<SubjectRegistration> insert(@RequestBody SubjectRegistration obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SubjectRegistration> update(@PathVariable Long id, @RequestBody SubjectRegistration obj) {
		service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
