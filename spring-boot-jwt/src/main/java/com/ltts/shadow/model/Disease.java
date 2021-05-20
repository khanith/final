package com.ltts.shadow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Disease")
public class Disease {
	
	@Id
	@Column(name = "disease_name"  ,length = 50, nullable = false)
	private String disease_name;
	
	@Column(name = "surgical_limit"  ,length = 50, nullable = false)
	private String surgical_limit;

	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}

	public String getSurgical_limit() {
		return surgical_limit;
	}

	public void setSurgical_limit(String surgical_limit) {
		this.surgical_limit = surgical_limit;
	}

	public Disease(String disease_name, String surgical_limit) {
		super();
		this.disease_name = disease_name;
		this.surgical_limit = surgical_limit;
	}

	public Disease() {
		super();
	}

	
}
