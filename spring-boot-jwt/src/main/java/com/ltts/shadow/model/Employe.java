package com.ltts.shadow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employe {
	
	@Id
	@GeneratedValue
	private int Emp_id;
	
	@Column(name = "Emp_Name"  ,length = 50, nullable = false)
	private String Emp_Name;
	
	@Column(name = "Emp_Role"  ,length = 50, nullable = false)
	private String Emp_Role;
	
	@Column(name = "Emp_Department"  ,length = 50, nullable = false)
	private String Emp_Department;

	@OneToOne
    @JoinColumn(name = "Emp_id", nullable = false)
    private Patients Patients;
	
	public Employe() {
		super();
	}

	public Employe(int emp_Id, String name, String role, String dept) {
		super();
		Emp_id = emp_Id;
		Emp_Name = name;
		Emp_Role = role;
		Emp_Department = dept;
	}

	public int getEmp_Id() {
		return Emp_id;
	}

	public void setEmp_Id(int emp_Id) {
		Emp_id = emp_Id;
	}

	public String getName() {
		return Emp_Name;
	}

	public void setName(String name) {
		Emp_Name = name;
	}

	public String getRole() {
		return Emp_Role;
	}

	public void setRole(String role) {
		Emp_Role = role;
	}

	public String getDept() {
		return Emp_Department;
	}

	public void setDept(String dept) {
		Emp_Department = dept;
	}
	
	
	
}
