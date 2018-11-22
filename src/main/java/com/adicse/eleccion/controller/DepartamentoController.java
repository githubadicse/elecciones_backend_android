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

import com.adicse.eleccion.model.Departamento;
import com.adicse.eleccion.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
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
	
		Page<Departamento> page = departamentoService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Departamento> lst = page.getContent() ;
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
	public Departamento getEdit(@RequestParam("id") String id) {
		return departamentoService. findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Departamento postCreate(@RequestBody Departamento departamento) {
		
		departamento.setIddepartamento("");
		Departamento departamentoReturn = departamentoService.create(departamento);
		return departamentoReturn;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Departamento putUdate(@RequestBody Departamento departamento) {
		
	Departamento departamentoUpdate = departamentoService.findbyid(departamento.getIddepartamento()).get();
		
		BeanUtils.copyProperties(departamento, departamentoUpdate);
		
		return departamentoService.update(departamentoUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {	
		
		departamentoService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Departamento> getall(){
		return departamentoService.getall();
	}	

}
