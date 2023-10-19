package com.nt.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
	@Autowired
	private Animal animal;

	public Zoo() {
		System.out.println("Zoo Object");
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/*
	@Autowired
	private Tiger tiger;
	
	@Autowired
	private Lion lion;
	
	public Zoo() {
		System.out.println("Zoo Object");
	}
	
	public Tiger getTiger() {
		return tiger;
	}
	
	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}
	
	public Lion getLion() {
		return lion;
	}
	
	public void setLion(Lion lion) {
		this.lion = lion;
	}
	*/
}//class