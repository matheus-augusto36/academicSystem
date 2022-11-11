package com.matteo.academicSystem.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.academicSystem.entities.Student;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {
	
	@GetMapping
	ResponseEntity<Student> findAll() {
		Student st = new Student(1L, "Geralt of rivia", "123456789", new Date());
		return ResponseEntity.ok().body(st);
	}

}
