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

//@EnableAutoConfiguration
@SpringBootApplication
public class EleccionApplication implements CommandLineRunner {

	@Bean
	@Primary
	public ObjectMapper jsonMapper() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

		ObjectMapper mapper = new ObjectMapper();
		Hibernate5Module hm = new Hibernate5Module();
		hm.enable(Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);

		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		mapper.registerModule(hm);

		mapper.setSerializationInclusion(Include.NON_EMPTY);

		mapper.setDateFormat(df);

		return mapper;
	}

	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
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

		String s = "HERMILIO ACUÑA  MARTINEZ";
		System.out.println(s.substring(0,1));
		String passw = "h06141684";

		for (int i = 0; i < 2; i++) {
			String ps = passwordEncoder.encode(passw);
			System.out.println(ps);
		}

	}
}
