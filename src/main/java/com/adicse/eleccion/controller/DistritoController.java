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

import com.adicse.eleccion.model.Distrito;
import com.adicse.eleccion.service.DistritoService;


@RestController
@RequestMapping("/distrito")
public class DistritoController {

	@Autowired
	private DistritoService distritoService;
	

	
	
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
	
		Page<Distrito> page = distritoService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Distrito> lst = page.getContent() ;
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
	public Distrito getEdit(@RequestParam("id") String id) {
		return distritoService.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Distrito postCreate(@RequestBody Distrito distrito) {
		
		distrito.setIddistrito("");

		Distrito distritoReturn = distritoService.create(distrito);
		
		return distritoReturn;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Distrito putUdate(@RequestBody Distrito distrito) {
		
	Distrito distritoUpdate = distritoService.findbyid(distrito.getIddistrito()).get();
		
		BeanUtils.copyProperties(distrito, distritoUpdate);
		
		return distritoService.update(distritoUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {	
		
		distritoService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Distrito> getall(){
		return distritoService.getall();
	}	

	@RequestMapping("/getDistritoByIdProvincia")
	@ResponseBody	
	public List<Distrito> getDistritoByIdProvincia(@RequestParam("idProvincia") String idProvincia){
		
		List<Distrito> lst = distritoService.getDistritoByIdProvincia(idProvincia);
		lst.sort((a,b)->a.getDscdistrito().compareTo(b.getDscdistrito()) );
		return lst;
	}
	
	
}
