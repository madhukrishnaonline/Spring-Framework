package com.nt.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.patient.entity.Patient;
import com.nt.queries.DBOperation;

public class SpringJPAMain 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.nt.*");
		context.refresh();
		
		Scanner scanner = new Scanner(System.in);
		
		/*Patient patient = new Patients();
		System.out.println("Enter Patient Id :: ");
		patient.setPatientId(scanner.nextLine());
		System.out.println("Enter Patient Age :: ");
		patient.setPatientAge(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter Patient Name :: ");
		patient.setPatientName(scanner.nextLine());
		System.out.println("Enter Patient Disease :: ");
		patient.setPatientDisease(scanner.nextLine());
		System.out.println("Enter Patient Mobile :: ");
		patient.setPatientPhone(Long.parseLong(scanner.nextLine()));*/
		
		DBOperation dbOperation =  context.getBean(DBOperation.class);
		/*dbOperation.addPatient(patient);
		System.out.println("Row Inserted Successfully....");*/
		
		//System.out.println("Enter Id to Fetch :: ");
		Patient patient1 = dbOperation.fetchPatientsById("lk123");
		System.out.println("Patient "+patient1);
		
		System.out.println("**********All Patients***********");
		 List<Patient> patiens = dbOperation.selectAllPatients();
		for(Patient p: patiens)
		{
			System.out.println(p.toString());
		}//for
		
		/*System.out.println("Enter Id to delete:: ");
		dbOperation.deletePatientsById(scanner.nextLine());
		System.out.println("Patient Record Deleted.......");*/
		
		//System.out.println("Enter Name to Fetch :: ");
		List<Patient> patientNames = dbOperation.fetchPatientByName("Naresh");
		for(Patient p:patientNames)
		{
			System.out.println("Patient By Name \n"+p);
		}
		
		List<Patient> patientNameAndDisease = dbOperation.findPatientsByNameAndDisease("Subbu", "Lust");
		for(Patient p:patientNameAndDisease)
		{
			System.out.println("*****Patients with Name \""+p.getName()+"\" and Disease \""+p.getDisease()+"\"*****\n"+p);
		}
		
		scanner.close();
	}//main
}//class