package com.matteo.academicSystem.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matteo.academicSystem.entities.Course;
import com.matteo.academicSystem.entities.Subject;

@Embeddable
public class SubjectRegistrationPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

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
