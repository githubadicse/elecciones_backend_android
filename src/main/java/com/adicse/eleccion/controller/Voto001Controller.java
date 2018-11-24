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

import com.adicse.eleccion.model.MesaDeVotacion;
import com.adicse.eleccion.model.Voto001;
import com.adicse.eleccion.model.Voto002;
import com.adicse.eleccion.service.MesaDeVotacionService;
import com.adicse.eleccion.service.Voto001Service;

@RestController
@RequestMapping("/voto001")
public class Voto001Controller {
	
	@Autowired
	private Voto001Service voto001Service;
	

	@Autowired
	MesaDeVotacionService mesaDeVotacionService;
	
	
	
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
	
		Page<Voto001> page = voto001Service.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Voto001> lst = page.getContent() ;
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
	public Voto001 getEdit(@RequestParam("id") Integer id) {
		Voto001 voto001 = voto001Service.findbyid(id).get();
		
		for(Voto002 voto002: voto001.getVoto002s()) { 
			voto002.setVoto001(null);
		}
		return voto001;
	}
	
	@RequestMapping("filterByNumMesa")
	@ResponseBody
	public Voto001 getByNumMesa(@RequestParam("id") Integer id) {		
		Voto001 voto001 = voto001Service.getVotoByNumeroMesa(id);
		
		if (voto001 == null) { return null;}
		
		for(Voto002 voto002: voto001.getVoto002s()) { 
			voto002.setVoto001(null);
		}
		return voto001;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Voto001 postCreate(@RequestBody Voto001 voto001) {
		
		voto001.setIdvoto001(0);
		MesaDeVotacion mesaDeVotacion = mesaDeVotacionService.findbyid( voto001.getMesaDeVotacion().getIdMesaDeVotacion() ).get() ;
		mesaDeVotacion.setFlagRegistrado(true);
		mesaDeVotacionService.update(mesaDeVotacion);
		
		for(Voto002 row: voto001.getVoto002s() ) {
			row.setVoto001(voto001);
		}
		Voto001 voto001Return = voto001Service.create(voto001);
		
		for(Voto002 row: voto001Return.getVoto002s() ) {
			row.setVoto001(null);
		}		

		return voto001Return;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Voto001 putUdate(@RequestBody Voto001 voto001) {
		
	Voto001 voto001Update = voto001Service.findbyid(voto001.getIdvoto001()).get();
	
		for(Voto002 row: voto001.getVoto002s() ) {
			row.setVoto001(voto001);
		}

		
		BeanUtils.copyProperties(voto001, voto001Update);
		
		return voto001Service.update(voto001Update);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {	
		
		voto001Service.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Voto001> getall(){
		return voto001Service.getall();
	}



}
