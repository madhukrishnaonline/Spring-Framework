package com.nt.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.patient.entity.Patient;
import com.nt.queries.DBOperation2;

public class SpringJPAMain2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.nt.*");
		context.refresh();
		
		DBOperation2 dbOperation2 = context.getBean(DBOperation2.class);
		
		
		List<Patient> patients =  dbOperation2.loadAllPatients();
		System.out.println(patients);
		
		List<Patient> patients2 =  dbOperation2.loadPatientByName("Lokesh");
		System.out.println(patients2);
		
		System.out.println("=========Index based Native Query==========");
		List<Patient> patients3 =  dbOperation2.loadAllPatientsByNameAndAge("Lokesh",22);
		System.out.println(patients3);
		
		System.out.println("===========Name Based Native Query===========");
		List<Patient> patients4 = dbOperation2.loadAllPatientsByDiseaseAndName("Subbu","Lust");
		System.out.println(patients4);
		
		dbOperation2.insertIntoPatient("vamsi", "lusti","va6si", 813149398, 24);
		
		System.out.println("==========JPQL Query==========");
		List<Patient> patients5 =  dbOperation2.loadAllPatientsByJPQL();
		System.out.println(patients5);
		
		System.out.println("==========Names===========");
		List<String> patients6 = dbOperation2.loadAllPatientNamesByJPQL();
		System.out.println(patients6);
	}//main
}//class