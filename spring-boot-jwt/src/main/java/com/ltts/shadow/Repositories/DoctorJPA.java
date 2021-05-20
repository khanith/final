package com.ltts.shadow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ltts.shadow.model.Doctor_Login;

public interface DoctorJPA extends JpaRepository<Doctor_Login, Integer>
{
//	@Query(value="select u from doctor_tbl u where u.doc_user=?1 AND u.doc_pass=?2")
//	public List<Doctor_Login> getVal(String user, String pass);
	
	@Query(value="select * from doctor_tbl where doc_user=?1 AND doc_pass=?2",nativeQuery=true)
	public List<Doctor_Login> getVal(String user, String pass);

}
