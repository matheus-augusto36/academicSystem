package com.matteo.academicSystem.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	StudentRepository stdRepository;	

	@Override
	public void run(String... args) throws Exception {
		Student st1 = new Student(null, "Geralt of rivia", "123456789", new Date());
		Student st2 = new Student(null, "Vesemir", "123456789", new Date());
		
		stdRepository.saveAll(Arrays.asList(st1,st2));
	}

}
