package com.adicse.eleccion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.eleccion.components.Procesos;

@RestController
@RequestMapping("/procesos")
public class ProcesosController {
	
	
	@Autowired
	Procesos procesos;
	
	@RequestMapping("/actualizaClave")
	public void actualizaClave() {
		procesos.actualizaClave();
	}

}
