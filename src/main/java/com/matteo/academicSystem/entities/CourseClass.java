package com.matteo.academicSystem.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CourseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer number;
	private Date startDate;
	private Integer vacancies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "courseClass")
	private List<Registration> registrations = new ArrayList<>();
	
	public CourseClass(Long id, Integer number, Date startDate, Integer vacancies) {
		super();
		this.id = id;
		this.number = number;
		this.startDate = startDate;
		this.vacancies = vacancies;
	}
	
	public CourseClass() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getVacancies() {
		return vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}
	
	public void addRegistration(Registration registration) {
		registrations.add(registration);
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
		CourseClass other = (CourseClass) obj;
		return Objects.equals(id, other.id);
	}
}
