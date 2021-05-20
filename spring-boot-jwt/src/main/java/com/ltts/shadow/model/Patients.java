package com.ltts.shadow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.ltts.shadow.Repositories.PatientJPA;

@Entity(name = "Patients")
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Patient_ID;
	
	@Column(name = "Patient_Name"  ,length = 50, nullable = false)
	private String Pat_Name;
	
	@Column(name = "Patient_Age"  ,length = 50, nullable = false)
	private String Pat_Age;
	
	@Column(name = "Patient_Symptoms"  ,length = 50, nullable = false)
	private String Pat_Symptoms;
	
	@Column(name = "v_date"  ,length = 50)
	private String v_date;
	
	@Column(name = "Last_vdate"  ,length = 50)
	private String Last_vdate;
	
	@Column
	private String ename;
	
	@Column
	private int Emp_id;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="Patients")
    private Employe emp;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="Patients")
    private PatientDiagnosis pd;

	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}

	public String getPat_Name() {
		return Pat_Name;
	}

	public void setPat_Name(String pat_Name) {
		Pat_Name = pat_Name;
	}

	public String getPat_Age() {
		return Pat_Age;
	}

	public void setPat_Age(String pat_Age) {
		Pat_Age = pat_Age;
	}

	public String getPat_Symptoms() {
		return Pat_Symptoms;
	}

	public void setPat_Symptoms(String pat_Symptoms) {
		Pat_Symptoms = pat_Symptoms;
	}

	public String getV_date() {
		return v_date;
	}

	public void setV_date(String v_date) {
		this.v_date = v_date;
	}

	public String getLast_vdate() {
		return Last_vdate;
	}

	public void setLast_vdate(String last_vdate) {
		Last_vdate = last_vdate;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}

	public Patients(int patient_ID, String pat_Name, String pat_Age, String pat_Symptoms, String v_date,
			String last_vdate, String ename, int emp_id) {
		super();
		Patient_ID = patient_ID;
		Pat_Name = pat_Name;
		Pat_Age = pat_Age;
		Pat_Symptoms = pat_Symptoms;
		this.v_date = v_date;
		Last_vdate = last_vdate;
		this.ename = ename;
		Emp_id = emp_id;
	}

	public Patients() {
		super();
	}
	
	
}
