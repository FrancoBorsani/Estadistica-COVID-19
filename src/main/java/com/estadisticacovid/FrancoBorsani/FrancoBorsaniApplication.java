package com.estadisticacovid.FrancoBorsani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class FrancoBorsaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrancoBorsaniApplication.class, args);
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));
	}
	
	

}
