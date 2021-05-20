package com.ltts.shadow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Doctor_TBL")
public class Doctor_Login {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String docUser;
	@Column
	private String docPass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocUser() {
		return docUser;
	}
	public void setDocUser(String docUser) {
		this.docUser = docUser;
	}
	public String getDocPass() {
		return docPass;
	}
	public void setDocPass(String docPass) {
		this.docPass = docPass;
	}
	public Doctor_Login(int id, String docUser, String docPass) {
		super();
		this.id = id;
		this.docUser = docUser;
		this.docPass = docPass;
	}
	public Doctor_Login() {
		super();
	}
	
	
}
