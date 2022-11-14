package com.matteo.academicSystem.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.matteo.academicSystem.entities.PK.SubjectRegistrationPK;

@Entity
@Table(name = "subject_registration")
public class SubjectRegistration {

	@EmbeddedId
	private SubjectRegistrationPK id = new SubjectRegistrationPK();
	
	public SubjectRegistration() {
		
	}
	
	public SubjectRegistration(Course course, Subject subject) {
		id.setCourse(course);
		id.setSubject(subject);
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
		SubjectRegistration other = (SubjectRegistration) obj;
		return Objects.equals(id, other.id);
	}
	
}
