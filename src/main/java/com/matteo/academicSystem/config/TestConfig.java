package com.matteo.academicSystem.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matteo.academicSystem.entities.Course;
import com.matteo.academicSystem.entities.CourseClass;
import com.matteo.academicSystem.entities.Registration;
import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.entities.Subject;
import com.matteo.academicSystem.repositories.CourseClassRepository;
import com.matteo.academicSystem.repositories.CourseRepository;
import com.matteo.academicSystem.repositories.RegistrationRepository;
import com.matteo.academicSystem.repositories.StudentRepository;
import com.matteo.academicSystem.repositories.SubjectRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private StudentRepository stdRepository;	
	
	@Autowired
	private RegistrationRepository rgRepository;
	
	@Autowired
	private CourseClassRepository ccRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository sbRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Course course1 = new Course(null, "ADS", 6, 10000.0);
		
		courseRepository.save(course1);
		
		CourseClass cc1 = new CourseClass(null, 1, new Date(), 40, course1);
		ccRepository.save(cc1);
		
		course1.addCourseClass(cc1);
		courseRepository.save(course1);
		
		Subject sbj1 = new Subject(null, "Estatística", "Mexer com gráfico e tabela", 7.0);
		Subject sbj2 = new Subject(null, "Python", "Fazer if e else com identação", 7.0);
		
		sbRepository.saveAll(Arrays.asList(sbj1, sbj2));
		
		Registration rg1 = new Registration(null);
		Registration rg2 = new Registration(null);
		rg1.setCourseClass(cc1);
		rg2.setCourseClass(cc1);
		rgRepository.saveAll(Arrays.asList(rg1, rg2));
		
		cc1.addRegistration(rg1);
		cc1.addRegistration(rg2);
		ccRepository.save(cc1);
		
		
		Student st1 = new Student(null, "Geralt of rivia", "123456789", new Date(), rg1);
		Student st2 = new Student(null, "Vesemir", "123456789", new Date(), rg2);
		
		stdRepository.saveAll(Arrays.asList(st1,st2));
		
		rg1.setStudent(st1);
		rg2.setStudent(st2);
		
		rgRepository.saveAll(Arrays.asList(rg1, rg2));
		
	}

}
