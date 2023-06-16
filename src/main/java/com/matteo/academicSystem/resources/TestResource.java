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

import com.matteo.academicSystem.entities.Teacher;
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
	
	@PostMapping
	public ResponseEntity<Test> insert(@RequestBody Test obj) {
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
	public ResponseEntity<Test> update(@PathVariable Long id, @RequestBody Test obj) {
		service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
