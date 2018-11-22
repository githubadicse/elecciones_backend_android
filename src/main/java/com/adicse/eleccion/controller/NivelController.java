package com.adicse.eleccion.controller;


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

import com.adicse.eleccion.model.Nivel;
import com.adicse.eleccion.service.NivelService;



@RestController
@RequestMapping("/nivel")
public class NivelController {
	
	@Autowired
	private NivelService nivelService;
	

	
	
	
	@RequestMapping("/pagination")
	@ResponseBody
	public  Map<String,Object>  pagination(
			@RequestParam("pagenumber") Integer pagenumber,
			@RequestParam("rows") Integer rows,
			@RequestParam("sortdireccion") String sortdireccion,
			@RequestParam("sortcolumn") String sortcolumn,
			@RequestParam("filters")  Object filters		
			){
	
		Map<String,Object> response = new HashMap<String, Object>();
	
		Page<Nivel> page = nivelService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Nivel> lst = page.getContent() ;
		if(lst.size() == 0 ) {
			 lst = new ArrayList<>();
		}
		
		response.put("data", lst);
		response.put("totalCount", page.getTotalElements());
		response.put("success", true);
		
		return response;
	
				
	}	
	
	@RequestMapping("/edit")
	@ResponseBody
	public Nivel getEdit(@RequestParam("id") Integer id) {
		return nivelService.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Nivel postCreate(@RequestBody Nivel nivel) {
		nivel.setIdnivel(0);
		return nivelService.create(nivel);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Nivel putUdate(@RequestBody Nivel nivel) {
		
	Nivel nivelUpdate = nivelService.findbyid(nivel.getIdnivel()).get();
		
		BeanUtils.copyProperties(nivel, nivelUpdate);
		
		return nivelService.create(nivelUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {	
		
		nivelService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Nivel> getall(){
		return nivelService.getall();
	}



}
