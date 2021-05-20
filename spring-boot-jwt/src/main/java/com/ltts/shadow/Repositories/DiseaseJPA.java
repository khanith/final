package com.ltts.shadow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.shadow.model.Disease;
import com.ltts.shadow.model.Employe;

public interface DiseaseJPA extends JpaRepository<Disease, Integer> {

	@Query("select u.disease_name from Disease u") 
	 public List<Disease> getDiseases();
}
