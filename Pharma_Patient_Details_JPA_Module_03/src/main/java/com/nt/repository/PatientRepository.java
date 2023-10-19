package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.patient.entity.Patient;

//@Component
public interface PatientRepository extends JpaRepository<Patient, String> 
{
	
     List<Patient> findByName(String patientName);
     
     List<Patient> findByNameAndDisease(String name,String disease);
}//interface
