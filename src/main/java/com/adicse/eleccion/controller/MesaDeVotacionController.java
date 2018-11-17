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
import com.adicse.eleccion.service.MesaDeVotacionService;

@RestController
@RequestMapping("/mesaDeVotacion")
public class MesaDeVotacionController {
	
	@Autowired
	private MesaDeVotacionService mesaDeVotacionService;
	

	
	
	
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
	
		Page<MesaDeVotacion> page = mesaDeVotacionService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<MesaDeVotacion> lst = page.getContent() ;
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
	public MesaDeVotacion getEdit(@RequestParam("id") Integer id) {
		return mesaDeVotacionService.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public MesaDeVotacion postCreate(@RequestBody MesaDeVotacion mesaDeVotacion) {
		mesaDeVotacion.setIdMesaDeVotacion(0);
		return mesaDeVotacionService.create(mesaDeVotacion);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public MesaDeVotacion putUdate(@RequestBody MesaDeVotacion mesaDeVotacion) {
		
	MesaDeVotacion mesaDeVotacionUpdate = mesaDeVotacionService.findbyid(mesaDeVotacion.getIdMesaDeVotacion()).get();
		
		BeanUtils.copyProperties(mesaDeVotacion, mesaDeVotacionUpdate);
		
		return mesaDeVotacionService.update(mesaDeVotacionUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id) {	
		
		mesaDeVotacionService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<MesaDeVotacion> getall(){
		return mesaDeVotacionService.getall();
	}	
	
	
	@RequestMapping("/getMesasDeVotacionByIdPersonero")
	@ResponseBody	
	public List<MesaDeVotacion> getMesasDeVotacionByIdPersonero(@RequestParam("idPersonero") String idPersonero, @RequestParam("flagRegistrado") Boolean flagRegistrado){
		return mesaDeVotacionService.getMesasDeVotacionByIdPersonero(idPersonero, flagRegistrado);
	}

}
