package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.patient.entity.Patient;

public interface PatientRepository2 extends JpaRepository<Patient, String>
{
	@Query(value = "select * from patient", nativeQuery = true)
	List<Patient> selectAllPatients();
	
	@Query(value = "select * from patient where name=?", nativeQuery = true)
	List<Patient> selectAllPatientsByName(String name);
	
	//Index Based Native Query
	@Query(value = "select * from patient where name=?1 and age=?2", nativeQuery = true)
	List<Patient> selectAllPatientsByNameAndAge(String name,int age);
	
	//Name Based Native Query
	@Query(value = "select * from patient where disease=:disease and name=:name", nativeQuery = true)
	List<Patient> selectAllPatientsByDiseaseAndName
	                                                                             (@Param("name") String name,@Param("disease") String disease);
	
	@Transactional
	@Modifying
	@Query(value = "insert into patient values(:id,:age,:disease,:name,:mobile)", nativeQuery = true)
	void insertIntoPatientValues(
														@Param("name") String name,
														@Param("disease") String disease,
														@Param("id") String id,
														@Param("mobile") long mobile,
														@Param("age") int age
														);
	
	@Query(value = "Select p from Patient p")
	List<Patient> selectAllPatientsJPQL();
	
	@Query(value = "Select p.name from Patient p")
	List<String> selectAllPatientsNameJPQL();
	
}//interface