package com.adicse.eleccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

@SpringBootApplication
public class EleccionApplication implements CommandLineRunner {
	
	
	@Bean
	@Primary
	public ObjectMapper jsonMapper() {
	
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		
	    ObjectMapper mapper = new ObjectMapper();
	    Hibernate5Module hm = new Hibernate5Module();
	    //hm.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
	    hm.enable(Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
	    
	    mapper.registerModule(hm);
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    
	    // This doesn't work with Hibernate4Module :-(
	    //mapper.setSerializationInclusion(Include.NON_NULL);
	    mapper.setSerializationInclusion(Include.NON_EMPTY);
	    //df.setTimeZone(TimeZone.getTimeZone("UTC"));
	    mapper.setDateFormat(df);
	   
	    return mapper;
	}	
	
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
