package com.matteo.academicSystem.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import com.matteo.academicSystem.entities.Course;
import com.matteo.academicSystem.entities.Subject;

@Embeddable
public class SubjectRegistrationPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Course course;
	private Subject subject;
	
	public SubjectRegistrationPK(Course course, Subject subject) {
		super();
		this.course = course;
		this.subject = subject;
	}
	
	public SubjectRegistrationPK() {
		
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectRegistrationPK other = (SubjectRegistrationPK) obj;
		return Objects.equals(course, other.course) && Objects.equals(subject, other.subject);
	}
}
