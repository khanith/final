package com.ltts.shadow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.ltts.shadow.model.Patients;

public interface PatientJPA extends JpaRepository<Patients, Integer> 
{
	@Query("SELECT u FROM Patients u WHERE u.Patient_ID = ?1")
	public Patients findById(int id);
//	@Query(value="SELECT emp_name as doctor_assigned,patients.emp_id, patients.patient_age,patients.patient_id, patients.patient_name, patients.patient_symptoms, patients.v_date, patients.last_vdate FROM employee INNER JOIN patients ON employee.emp_id = patients.emp_id",nativeQuery=true)
//	public List<Patients> findallpatient();
	@Query(value="SELECT emp_name FROM employee INNER JOIN patients ON employee.emp_id = patients.emp_id WHERE employee.emp_id=?1",nativeQuery=true)
	public String findEmpname(int id);
}
