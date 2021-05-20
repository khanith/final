package com.ltts.shadow.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PatientDiagnosis")
public class PatientDiagnosis {
	
	@GeneratedValue
	private int d_id;
    
	@Id
	private int Patient_ID;
	
	@OneToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patients Patients;
	
	@Column(nullable = false)
	private String blood_test_results;
	
	@Column
	private String bp;
	
	@Column
	private String surgery_required;
	
	@Column
	private Date surgical_date;
	
	@Column
	private String anesthetic_name;
	
	@Column
	private String nurse_name;
	
	@Column
	private  String disease_name;
	


	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}


//	public int getPatients() {
//		return Patients.getPatient_ID();
//	}
//
//	public void setPatients(Patients patients) {
//		Patients = patients;
//	}

	public String getBlood_test_results() {
		return blood_test_results;
	}

	public void setBlood_test_results(String blood_test_results) {
		this.blood_test_results = blood_test_results;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getSurgery_required() {
		return surgery_required;
	}

	public void setSurgery_required(String surgery_required) {
		this.surgery_required = surgery_required;
	}

	public Date getSurgical_date() {
		return surgical_date;
	}

	public void setSurgical_date(Date surgical_date) {
		this.surgical_date = surgical_date;
	}

	public String getAnesthetic_name() {
		return anesthetic_name;
	}

	public void setAnesthetic_name(String anesthetic_name) {
		this.anesthetic_name = anesthetic_name;
	}

	public String getNurse_name() {
		return nurse_name;
	}

	public void setNurse_name(String nurse_name) {
		this.nurse_name = nurse_name;
	}
	
	
	
	public String getDisease_name() {
		return disease_name;
	}

	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}
	
	
	
	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}

	public PatientDiagnosis(int d_id, String blood_test_results, String bp,
			String surgery_required, Date surgical_date, String anesthetic_name, String nurse_name,String disease_name,int patient_ID) {
		super();
		this.d_id = d_id;
		this.blood_test_results = blood_test_results;
		this.bp = bp;
		this.surgery_required = surgery_required;
		this.surgical_date = surgical_date;
		this.anesthetic_name = anesthetic_name;
		this.nurse_name = nurse_name;
		this.disease_name=disease_name;
		Patient_ID=patient_ID;
	}

	public PatientDiagnosis() {
		super();
	}
	
	
}
