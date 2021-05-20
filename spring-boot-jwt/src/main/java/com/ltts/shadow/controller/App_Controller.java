package com.ltts.shadow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.shadow.Repositories.DiseaseJPA;
import com.ltts.shadow.Repositories.DoctorJPA;
import com.ltts.shadow.Repositories.EmployeeJPA;
import com.ltts.shadow.Repositories.PatientDiagnosisJPA;
import com.ltts.shadow.Repositories.PatientJPA;
import com.ltts.shadow.Repositories.UserJPA;
import com.ltts.shadow.model.Disease;
import com.ltts.shadow.model.Doctor_Login;
import com.ltts.shadow.model.Employe;
import com.ltts.shadow.model.PatientDiagnosis;
import com.ltts.shadow.model.Patients;
import com.ltts.shadow.model.UsersLog;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class App_Controller 
{
	@Autowired
	EmployeeJPA empjpa;
	@Autowired
	PatientJPA patjpa;
	@Autowired
	UserJPA ujpa;
	@Autowired
	DoctorJPA docjpa;
	@Autowired
	DiseaseJPA djpa;
    @Autowired
    PatientDiagnosisJPA pdjpa;
	
//	  @GetMapping("/p/{doc_id}") public String getEmployee(@PathVariable int doc_id)
//	  {
//		  String docname=empjpa.getdoc(doc_id); 
//	      return docname; 
//	  }
	 
	 
	@GetMapping("")
	public List<Patients> getPatients()
	{
		List<Patients> pat2=patjpa.findAll();
		return pat2;
	}
	
	@DeleteMapping("/pat/{id}")
    public Patients delete(@PathVariable int id)
    {
		Patients deletedpat=null;
		List<Patients> pat=patjpa.findAll();
		for(Patients patient : pat)
		{
			if (patient.getPatient_ID()==id) 
			{
				patjpa.deleteById(id);
				pat.remove(patient);
				deletedpat=patient;
				break;
			}
		}
		return deletedpat;
    }
	@PutMapping("/patupdate")
	public Patients getup(@RequestBody Patients pat)
	{
		Patients ext=patjpa.findById(pat.getPatient_ID());
		if(!(pat.getPat_Name().equals(null)))
			ext.setPat_Name(pat.getPat_Name());
		
		if(!(pat.getPat_Symptoms().equals(null)))
			ext.setPat_Symptoms(pat.getPat_Symptoms());
		return patjpa.save(ext);
		
	}
	@PostMapping("/add")
	public Patients create(@RequestBody Patients user) {
		patjpa.save(user);
		System.out.println();
		return user;
	}
	@PostMapping("/genuser")
	public UsersLog createUser(@RequestBody UsersLog users)
	{
		ujpa.save(users);
		System.out.println();
		return users;
	}
	@GetMapping("/getdoc")
	public List<Employe> listDoc()
	{
		List<Employe> empname=empjpa.getname();
		return empname;
	}
	@PostMapping("/val")
	public List<Doctor_Login> validate(@RequestBody Doctor_Login doc)
	{
		List<Doctor_Login> docret=docjpa.getVal(doc.getDocUser(), doc.getDocPass());
//		List<Doctor_Login> docret=djpa.findAll();
		return docret;
	}
	@GetMapping("/disease")
	public List<Disease> listDisease()
	{
		List<Disease> diseasename=djpa.getDiseases();
		return diseasename;
	}

	@GetMapping("/diagnosis")
	public List<PatientDiagnosis> listDiagnosis()
	{
		List<PatientDiagnosis> d =pdjpa.getAll();
		return d;
	}
	@PostMapping("/diagsave")
	public PatientDiagnosis createDiag(@RequestBody PatientDiagnosis diag)
	{
		pdjpa.save(diag);
		System.out.println();
		return diag;
	}
	@GetMapping("/chosen/{id}")
	public List<PatientDiagnosis> chosenP(@PathVariable int id)
	{
		List<PatientDiagnosis> di=pdjpa.findByPatient_ID(id);
		return di;
	}
}
