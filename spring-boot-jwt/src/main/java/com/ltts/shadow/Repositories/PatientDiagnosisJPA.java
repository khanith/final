package com.ltts.shadow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.shadow.model.PatientDiagnosis;



public interface PatientDiagnosisJPA extends JpaRepository<PatientDiagnosis, Integer>{
	@Query("select u from PatientDiagnosis u") 
	 public List<PatientDiagnosis> getAll();
	@Query("select d from PatientDiagnosis d where d.Patient_ID=?1")
	public List<PatientDiagnosis> findByPatient_ID(int id);
}
