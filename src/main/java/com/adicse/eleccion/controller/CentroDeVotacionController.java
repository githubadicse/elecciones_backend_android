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

import com.adicse.eleccion.model.CentroDeVotacion;
import com.adicse.eleccion.service.CentroDeVotacionService;



@RestController
@RequestMapping("/centrodevotacion")
public class CentroDeVotacionController {
	
	@Autowired
	private CentroDeVotacionService centrodevotacionService;
	

	
	
	
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
	
		Page<CentroDeVotacion> page = centrodevotacionService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<CentroDeVotacion> lst = page.getContent() ;
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
	public CentroDeVotacion getEdit(@RequestParam("id") String id) {
		return centrodevotacionService.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public CentroDeVotacion postCreate(@RequestBody CentroDeVotacion centrodevotacion) {
		centrodevotacion.setIdCentroDeVotacion("");
		return centrodevotacionService.create(centrodevotacion);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public CentroDeVotacion putUdate(@RequestBody CentroDeVotacion centrodevotacion) {
		
	CentroDeVotacion centrodevotacionUpdate = centrodevotacionService.findbyid(centrodevotacion.getIdCentroDeVotacion()).get();
		
		BeanUtils.copyProperties(centrodevotacion, centrodevotacionUpdate);
		
		return centrodevotacionService.create(centrodevotacionUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {	
		
		centrodevotacionService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<CentroDeVotacion> getall(){
		return centrodevotacionService.getall();
	}
	
	@RequestMapping("/getCentroDeVotacionByDistrito")
	@ResponseBody	
	public List<CentroDeVotacion> getCentroDeVotacionByDistrito(@RequestParam("idDistrito") String idDistrito){
		return centrodevotacionService.getCentroDeVotacionByDistrito(idDistrito);
	}



}
