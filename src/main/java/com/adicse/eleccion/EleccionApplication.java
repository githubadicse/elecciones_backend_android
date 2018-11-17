package com.adicse.eleccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EleccionApplication implements CommandLineRunner {
	
	@Bean
	public BCryptPasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public static void main(String[] args) {
		SpringApplication.run(EleccionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String passw = "admin";
		
		for(int i=0 ; i < 2 ; i++) {
			String ps = passwordEncoder.encode(passw);
			System.out.println(ps);
		}		
		
	}
}
