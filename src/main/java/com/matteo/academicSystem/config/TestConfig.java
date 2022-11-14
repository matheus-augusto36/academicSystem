package com.matteo.academicSystem.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.repositories.RegistrationRepository;
import com.matteo.academicSystem.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	StudentRepository stdRepository;	
	
	@Autowired
	RegistrationRepository rgRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Registration rg1 = new Registration(null);
		Registration rg2 = new Registration(null);
		
		rgRepository.saveAll(Arrays.asList(rg1, rg2));
		
		Student st1 = new Student(null, "Geralt of rivia", "123456789", new Date(), rg1);
		Student st2 = new Student(null, "Vesemir", "123456789", new Date(), rg2);
		
		stdRepository.saveAll(Arrays.asList(st1,st2));
		
		rg1.setStudent(st1);
		rg2.setStudent(st2);
		
		rgRepository.saveAll(Arrays.asList(rg1, rg2));
		// stdRepository.saveAll(Arrays.asList(st1,st2));
	}

}
