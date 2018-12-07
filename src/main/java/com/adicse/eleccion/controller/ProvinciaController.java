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

import com.adicse.eleccion.model.Provincia;
import com.adicse.eleccion.service.ProvinciaService;


@RestController
@RequestMapping("/provincia")
public class ProvinciaController {
	
	
	@Autowired
	private ProvinciaService provinciaService;
	
	
	
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
	
		Page<Provincia> page = provinciaService.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Provincia> lst = page.getContent() ;
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
	public Provincia getEdit(@RequestParam("id") String id) {
		return provinciaService.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Provincia postCreate(@RequestBody Provincia provincia) {
		
		provincia.setIdprovincia("");

		Provincia provinciaReturn = provinciaService.create(provincia);
		
		return provinciaReturn;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Provincia putUdate(@RequestBody Provincia provincia) {
		
	Provincia provinciaUpdate = provinciaService.findbyid(provincia.getIdprovincia()).get();
		
		BeanUtils.copyProperties(provincia, provinciaUpdate);
		
		return provinciaService.update(provinciaUpdate);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {	
		
		provinciaService.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Provincia> getall(){
		return provinciaService.getall();
	}
	
	
	@RequestMapping("/getProvinciaByIdDepartamento")
	@ResponseBody	
	public List<Provincia> getProvinciaByIdDepartamento(@RequestParam("idDepartamento") String idDepartamento){
		List<Provincia> lst = provinciaService.getProvinciaByIdDepartamento(idDepartamento);
		lst.sort( (a,b)-> a.getDscprovincia().compareTo(b.getDscprovincia()) );
		return lst; 
		
	}

}
