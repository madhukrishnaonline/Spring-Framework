package com.nt.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.patient.entity.Patient;
import com.nt.repository.PatientRepository;

@Component
public class DBOperation 
{
	@Autowired
  private PatientRepository patientRepository;
	
	//addPatient || Update
	public void addPatient(Patient patient)
	{
		patientRepository.save(patient);
	}
	
	//findById
	public Patient fetchPatientsById(String patientId)
	{
		 Patient p = patientRepository.findById(patientId).get();
		 
		 return p;
	}
	
	//select All
	public List<Patient> selectAllPatients()
	{
		List<Patient> patients =  patientRepository.findAll();
		
		return patients;
	}
	
	//deleteById
	public void deletePatientsById(String patientId)
	{
		patientRepository.deleteById(patientId);
	}
	
	//findByName
	public List<Patient> fetchPatientByName(String patientName)
	{
		List<Patient> p =  patientRepository.findByName(patientName);
		
		return p;
	}
	
	//findByNameAndDisease
	public List<Patient> findPatientsByNameAndDisease(String name,String disease)
	{
		List<Patient> patient = patientRepository.findByNameAndDisease(name, disease);
		return patient;
	}
	
}//class