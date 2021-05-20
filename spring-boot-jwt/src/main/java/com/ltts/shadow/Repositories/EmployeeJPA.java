package com.ltts.shadow.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.shadow.model.Employe;


public interface EmployeeJPA extends JpaRepository<Employe, Integer>
{
	
//	 
	@Query("select u.Emp_Name from Employe u") 
	 public List<Employe> getname();
//	 
//	@Query(value="SELECT emp_name as doctor_assigned, patients.patient_id, patients.patient_name, patients.patient_symptoms, patients.v_date, patients.last_vdate FROM employee INNER JOIN patients ON employee.doc_id = patients.doc_id",nativeQuery=true)
//	public List<Employee> findByid();	
	
//	@Query("SELECT e.emp_name FROM Employee e")
//	public List<Employe> findName();
}
