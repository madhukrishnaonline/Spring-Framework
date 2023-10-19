package com.nt.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.patient.entity.Patient;
import com.nt.repository.PatientRepository2;

@Component
public class DBOperation2 
{

	@Autowired
	PatientRepository2 patientRepository2;
	
	//select AllPatients
	public List<Patient> loadAllPatients()
	{
		return patientRepository2.selectAllPatients(); 
	}
	
	//Select Patients by Name
	public List<Patient> loadPatientByName(String name)
	{
		return patientRepository2.selectAllPatientsByName(name);
	}
	
	//Select PatientsbyNameAndAge
	public List<Patient> loadAllPatientsByNameAndAge(String name,int age)
	{
		return patientRepository2.selectAllPatientsByNameAndAge(name, age);
	}
	
	//Select PatientsbyDiseaseAndName
	public List<Patient> loadAllPatientsByDiseaseAndName(String name,String disease)
	{
	   return patientRepository2.selectAllPatientsByDiseaseAndName(name, disease);	
	}
	
	//Insert into patient values 
	public void insertIntoPatient(String name,String disease,String id,long mobile,int age)
	{
		patientRepository2.insertIntoPatientValues(name, disease, id, mobile, age);
	}
	
	//select patients by JPQL query
	public List<Patient> loadAllPatientsByJPQL()
	{
		return patientRepository2.selectAllPatientsJPQL();
	}
	
	//select patients by name JPQL query
	public List<String> loadAllPatientNamesByJPQL()
	{
	     List<String> allPatientNames = patientRepository2.selectAllPatientsNameJPQL();
	     
	     return allPatientNames;
	}
	
}//class