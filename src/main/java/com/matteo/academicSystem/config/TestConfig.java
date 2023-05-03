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
import com.matteo.academicSystem.entities.StudentTest;
import com.matteo.academicSystem.entities.Subject;
import com.matteo.academicSystem.entities.SubjectRegistration;
import com.matteo.academicSystem.entities.Teacher;
import com.matteo.academicSystem.entities.Test;
import com.matteo.academicSystem.repositories.CourseClassRepository;
import com.matteo.academicSystem.repositories.CourseRepository;
import com.matteo.academicSystem.repositories.RegistrationRepository;
import com.matteo.academicSystem.repositories.StudentRepository;
import com.matteo.academicSystem.repositories.StudentTestRepository;
import com.matteo.academicSystem.repositories.SubjectRegistrationRepository;
import com.matteo.academicSystem.repositories.SubjectRepository;
import com.matteo.academicSystem.repositories.TeacherRepository;
import com.matteo.academicSystem.repositories.TestRepository;

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
	
	@Autowired
	private TeacherRepository tchRepository;
	
	@Autowired
	private SubjectRegistrationRepository srRepository;
	
	@Autowired
	private TestRepository tstRepository;
	
	@Autowired
	private StudentTestRepository sttsRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Course course1 = new Course(null, "ADS", 6, 10000.0);
		Course course2 = new Course(null, "Data Science", 6, 10000.0);
		
		courseRepository.saveAll(Arrays.asList(course1, course2));
		
		CourseClass cc2 = new CourseClass(null, 2, new Date(), 40, course2);
		CourseClass cc1 = new CourseClass(null, 1, new Date(), 40, course1);
		ccRepository.saveAll(Arrays.asList(cc1, cc2));
		
		course2.addCourseClass(cc2);
		course1.addCourseClass(cc1);
		courseRepository.saveAll(Arrays.asList(course2, course1));
		
		Teacher tch1 = new Teacher(null, "Vesemir", "987654321");
		Teacher tch2 = new Teacher(null, "Eddard Stark", "123456789");
		
		tchRepository.saveAll(Arrays.asList(tch1, tch2));
		
		Subject sbj1 = new Subject(null, "Estatística", "Mexer com gráfico e tabela", 7.0, tch1);
		Subject sbj2 = new Subject(null, "Python", "Fazer if e else com identação e achar que python é religião", 7.0, tch2);
		
		tch1.addSubject(sbj1);
		tch2.addSubject(sbj2);
		tchRepository.saveAll(Arrays.asList(tch1, tch2));
		
		sbRepository.saveAll(Arrays.asList(sbj1, sbj2));
		
		Test tst1 = new Test(null, 10.0, new Date(), 1, sbj1);
		Test tst2 = new Test(null, 10.0, new Date(), 1, sbj2);
		Test tst3 = new Test(null, 10.0, new Date(), 2, sbj1);
		
		sbj1.addTest(tst1);
		sbj1.addTest(tst3);
		sbj2.addTest(tst2);
		
		tstRepository.saveAll(Arrays.asList(tst1, tst2, tst3));
		sbRepository.saveAll(Arrays.asList(sbj1, sbj2));
			
		SubjectRegistration sr1 = new SubjectRegistration(course1, sbj1);
		SubjectRegistration sr2 = new SubjectRegistration(course1, sbj2);
		
		SubjectRegistration sr3 = new SubjectRegistration(course2, sbj2);
		SubjectRegistration sr4 = new SubjectRegistration(course2, sbj1);
		srRepository.saveAll(Arrays.asList(sr1, sr2, sr3, sr4));
		
		course1.addSubject(sr1);
		course1.addSubject(sr2);
		course2.addSubject(sr3);
		course2.addSubject(sr4);
		courseRepository.saveAll(Arrays.asList(course2, course1));
		
		Registration rg1 = new Registration(null);
		Registration rg2 = new Registration(null);
		rg1.setCourseClass(cc1);
		rg2.setCourseClass(cc2);
		rgRepository.saveAll(Arrays.asList(rg1, rg2));
		
		cc1.addRegistration(rg1);
		cc2.addRegistration(rg2);
		ccRepository.saveAll(Arrays.asList(cc1, cc2));
		
		Student st1 = new Student(null, "Geralt of Rivia", "123456789", new Date(), rg1);
		Student st2 = new Student(null, "Eskel", "123456789", new Date(), rg2);
		
		stdRepository.saveAll(Arrays.asList(st1,st2));
		
		
		rg1.setStudent(st1);
		rg2.setStudent(st2);
		
		rgRepository.saveAll(Arrays.asList(rg1, rg2));
		
		StudentTest stt1 = new StudentTest(tst1, st1);
		StudentTest stt2 = new StudentTest(tst2, st2);
		
		sttsRepository.saveAll(Arrays.asList(stt1, stt2));
	}

}
