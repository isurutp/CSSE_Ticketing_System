package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
		LocalPassenger lp = new LocalPassenger("John", "345345", "4564345", 54354, "test", new Date());
		lp.addUser();
		
	}
	

}
