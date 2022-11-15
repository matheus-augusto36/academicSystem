package com.matteo.academicSystem.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.matteo.academicSystem.enums.TestClassification;

@Entity
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double score;
	private Date date;
	private Integer classification;
	
	public Test() {
		
	}
	
	public Test(Long id, Double score, Date date, Integer classification) {
		super();
		this.id = id;
		this.score = score;
		this.date = date;
		this.classification = classification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TestClassification getClassification() {
		return TestClassification.valueOf(classification);
	}

	public void setClassification(TestClassification classification) {
		if(classification != null) {
			this.classification = classification.getCode();
		}
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
		Test other = (Test) obj;
		return Objects.equals(id, other.id);
	}
	
}
