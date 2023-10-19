package com.nt.zoo.animal;

import org.springframework.stereotype.Component;

import com.nt.zoo.Animal;

@Component
public class Lion implements Animal {

	@Override
	public void animal() {
		System.out.println("Lion Object");
	}

}//class