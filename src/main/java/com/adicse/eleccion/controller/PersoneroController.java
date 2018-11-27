package com.adicse.eleccion.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.eleccion.model.Personero;
import com.adicse.eleccion.pojo.PersoneroPojo;
import com.adicse.eleccion.service.PersoneroService;
import com.adicse.eleccion.utilitarios.ConvertidorUtilitario;

@RestController
@RequestMapping("/personero")
public class PersoneroController {
	
	
	@Autowired
	private PersoneroService personeroService;
	
	@Autowired
	private ConvertidorUtilitario convertidorUtilitario;
	
	
	@RequestMapping("/pagination")
	@ResponseBody
	public  Map<String,Object>  pagination(
			@RequestParam("pagenumber") Integer pagenumber,
			@RequestParam("rows") Integer rows,
			@RequestParam("sortdireccion") String sortdireccion,
			@RequestParam("sortcolumn") String sortcolumn,
			@RequestParam("filters") Object filters	
			){
	
		Map<String,Object> response = new HashMap<String, Object>();
	
		Page<Personero> page = personeroService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Personero> lst = page.getContent() ;
		
//		if(lst.size() == 0 ) {
//			 lst = new ArrayList<>();
//		}
		
		response.put("data", lst);
		response.put("totalCount", page.getTotalElements());
		response.put("success", true);
		
		return response;
	
				
	}	
	
	@RequestMapping("/edit")
	@ResponseBody
	public Personero getEdit(@RequestParam("id") String id) {
		return personeroService.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Personero postCreate(@RequestBody Personero personero) {
		personero.setIdpersonero(""); 
		return personeroService.create(personero);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Personero putUdate(@RequestBody Personero personero) {
		
	Personero personeroUpdate = personeroService.findbyid(personero.getIdpersonero()).get();
		
		BeanUtils.copyProperties(personero, personeroUpdate);
		
		return personeroService.update(personeroUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {	
		
		personeroService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Personero> getall(){
		return personeroService.getall();
	}	
	
	
	@RequestMapping("/getPersonerosByIdUsuario")
	@ResponseBody
	public List<PersoneroPojo> getPersonerosByIdUsuario(@RequestParam("idUsuario")  Integer idUsuario){
		List<Personero>  lstPersoneros = personeroService.getPersonerosByIdUsuario(idUsuario);
		PersoneroPojo personeroPojo = null;
		List<PersoneroPojo> lstPersoneroPojo = new ArrayList<>();
		for(Personero row:lstPersoneros) {
			personeroPojo = new PersoneroPojo();
			
			BeanUtils.copyProperties(row, personeroPojo);
			
			File file =new File(row.getFoto());
			if(file.exists()) {
				String fotoBase64 = convertidorUtilitario.encodeFileToBase64Binary(file);
				personeroPojo.setFotoBase64(fotoBase64);
			}
			
			lstPersoneroPojo.add(personeroPojo);
			
		}
		return lstPersoneroPojo;
				
	}
	
	
	

}
