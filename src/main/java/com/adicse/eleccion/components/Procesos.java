package com.adicse.eleccion.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.adicse.eleccion.model.Usuario;
import com.adicse.eleccion.service.UsuarioService;

@Component
public class Procesos {
	


	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void actualizaClave() {
		
		List<Usuario> lst = usuarioService.getall();
		
		for(Usuario row:lst) {
			String dni = row.getLogin().trim();
			String firstLetter = row.getNombres().trim().substring(0,1);
			String clave = firstLetter.toLowerCase() + dni;
			
			String ps = passwordEncoder.encode(clave);
			row.setClave(ps);
			usuarioService.update(row);
		}
	}

}
