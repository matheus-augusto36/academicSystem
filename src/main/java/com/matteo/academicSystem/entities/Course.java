package com.matteo.academicSystem.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String name;
	private Integer semesters;
	private Double price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private Set<CourseClass> classes = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.course")
	private Set<SubjectRegistration> subjects = new HashSet<>();
	
	public Course(Long id, String name, Integer semesters, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.semesters = semesters;
		this.price = price;
	}

	public Course() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSemesters() {
		return semesters;
	}

	public void setSemesters(Integer hours) {
		this.semesters = hours;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Set<CourseClass> getClasses() {
		return classes;
	}
	
	public Set<SubjectRegistration> getSubjects() {
		return subjects;
	}
	
	public void addCourseClass(CourseClass courseClass) {
		classes.add(courseClass);
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
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}
}
