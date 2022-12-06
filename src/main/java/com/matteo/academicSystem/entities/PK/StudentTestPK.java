package com.matteo.academicSystem.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matteo.academicSystem.entities.Student;
import com.matteo.academicSystem.entities.Test;

@Embeddable
public class StudentTestPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public int hashCode() {
		return Objects.hash(student, test);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentTestPK other = (StudentTestPK) obj;
		return Objects.equals(student, other.student) && Objects.equals(test, other.test);
	}
	
}
