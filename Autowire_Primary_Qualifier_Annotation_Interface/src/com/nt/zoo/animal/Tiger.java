package com.nt.zoo.animal;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.nt.zoo.Animal;

@Component("tiger")
@Primary
public class Tiger implements Animal {

	@Override
	public void animal() {
		System.out.println("Tiger Object");
	}

}//class