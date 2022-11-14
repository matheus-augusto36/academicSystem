package com.matteo.academicSystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.CourseClass;
import com.matteo.academicSystem.services.CourseClassService;

@RestController
@RequestMapping(value = "/classes")
public class CourseClassResource {

	@Autowired
	private CourseClassService service;

	@GetMapping
	public ResponseEntity<List<CourseClass>> findAll() {
		List<CourseClass> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseClass> findById(@PathVariable("id") Long id) {
		CourseClass obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
