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

import com.adicse.eleccion.model.Plantilla001;
import com.adicse.eleccion.model.Plantilla002;
import com.adicse.eleccion.service.Plantilla001Service;

@RestController
@RequestMapping("/plantilla001")
public class Plantilla001Controller {

	@Autowired
	private Plantilla001Service plantilla001Service;
	

	
	
	
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
	
		Page<Plantilla001> page = plantilla001Service.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Plantilla001> lst = page.getContent() ;
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
	public Plantilla001 getEdit(@RequestParam("id") Integer id) {
		
		Plantilla001 plantilla001 = plantilla001Service.findbyid(id).get();
		
		for(Plantilla002 row:plantilla001.getPlantilla002s() ) {
			row.setPlantilla001(null);
		}
		
		plantilla001.getPlantilla002s().sort( (a,b)-> a.getOrden().compareTo(b.getOrden()) );
		
		return plantilla001;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Plantilla001 postCreate(@RequestBody Plantilla001 plantilla001) {
		plantilla001.setIdplantilla001(0);
		return plantilla001Service.create(plantilla001);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Plantilla001 putUdate(@RequestBody Plantilla001 plantilla001) {
		
	Plantilla001 plantilla001Update = plantilla001Service.findbyid(plantilla001.getIdplantilla001() ).get();
		
		BeanUtils.copyProperties(plantilla001, plantilla001Update);
		
		return plantilla001Service.update(plantilla001Update);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {	
		
		plantilla001Service.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Plantilla001> getall(){
		return plantilla001Service.getall();
	}	
	
}
