package com.matteo.academicSystem.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matteo.academicSystem.entities.PK.StudentTestPK;

@Entity
@Table(name = "student_test")
public class StudentTest {

	@EmbeddedId
	private StudentTestPK id = new StudentTestPK();
	
	public StudentTest() {
		
	}
	
	public StudentTest(Test test, Student student) {
		id.setTest(test);
		id.setStudent(student);
	}
	
	public StudentTestPK getId() {
		return id;
	}
	
	@JsonIgnore
	public Test getTest() {
		return id.getTest();
	}
	
	public Student getStudent() {
		return id.getStudent();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentTest other = (StudentTest) obj;
		return Objects.equals(id, other.id);
	}
	
}

