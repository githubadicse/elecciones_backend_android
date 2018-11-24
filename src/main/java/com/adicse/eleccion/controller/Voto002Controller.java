package com.adicse.eleccion.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adicse.eleccion.model.Voto002;
import com.adicse.eleccion.pojo.ResultadoPojo;
import com.adicse.eleccion.pojo.ResultadoResumenPojo;
import com.adicse.eleccion.service.MesaDeVotacionService;
import com.adicse.eleccion.service.Voto002Service;



@RestController
@RequestMapping("/voto002")
public class Voto002Controller {
	
	@Autowired
	private Voto002Service voto002Service;
	

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
	
		Page<Voto002> page = voto002Service.pagination(pagenumber, rows, sortdireccion, sortcolumn, filters);
		
		List<Voto002> lst = page.getContent() ;
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
	public Voto002 getEdit(@RequestParam("id") String id) {
		return voto002Service.findbyid(id).get();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Voto002 postCreate(@RequestBody Voto002 voto002) {
		
		return voto002Service.create(voto002);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Voto002 putUdate(@RequestBody Voto002 voto002) {
		
	Voto002 voto002Update = voto002Service.findbyid(voto002.getIdvoto002()).get();
		
		BeanUtils.copyProperties(voto002, voto002Update);
		
		return voto002Service.create(voto002Update);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {	
		
		voto002Service.deletebyid(id);
	}
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Voto002> getall(){
		return voto002Service.getall();
	}

	@RequestMapping("/getResultado")
	@ResponseBody	
	public List<ResultadoPojo> getResultado(){
		return voto002Service.getResultado();
	}
	
	@RequestMapping("/getResultadoByDepartamento")
	@ResponseBody		
	public List<ResultadoResumenPojo> getResultadoResumenDepartamento(@Param("idDepartamento") String idDepartamento){
		
		List<ResultadoResumenPojo> lst = voto002Service.getResultadoResumenDepartamento(idDepartamento);
		
		Long _totalVotantesDepartamento = mesaDeVotacionService.getSumVotantesDepartamento(idDepartamento);
		Long _cntMesasDepartamento = mesaDeVotacionService.getCountVotantesDepartamento(idDepartamento);
		
		

		
		for(ResultadoResumenPojo row: lst) {
			row.set_totalVotantesDepartamento(_totalVotantesDepartamento);
			row.set_cntMesasDepartamento(_cntMesasDepartamento);
		}
		return lst;
	}
	
	
	@RequestMapping("/getResultadoResumenDepartamentoProvincia")
	@ResponseBody			
	public List<ResultadoResumenPojo> getResultadoResumenDepartamentoProvincia(String idDepartamento, String idProvincia){
		
		Long _totalVotantesDepartamento = mesaDeVotacionService.getSumVotantesDepartamento(idDepartamento);
		Long _totalVotantesProvincia = mesaDeVotacionService.getSumVotantesProvincia(idDepartamento, idProvincia);
		
		Long _cntMesasDepartamento = mesaDeVotacionService.getCountVotantesDepartamento(idDepartamento);
		Long _cntMesasProvincia = mesaDeVotacionService.getCountVotantesProvincia(idDepartamento, idProvincia);

		
		List<ResultadoResumenPojo> lst = voto002Service.getResultadoResumenDepartamentoProvincia(idDepartamento,idProvincia);
		for(ResultadoResumenPojo row: lst) {
			row.set_totalVotantesDepartamento(_totalVotantesDepartamento);
			row.set_totalVotantesProvincia(_totalVotantesProvincia);
			
			row.set_cntMesasDepartamento(_cntMesasDepartamento);
			row.set_cntMesasProvincia(_cntMesasProvincia);
		}
		
		return lst;
	}
	
	@RequestMapping("/getResultadoResumenDepartamentoProvinciaDistrito")
	@ResponseBody				
	public List<ResultadoResumenPojo> getResultadoResumenDepartamentoProvinciaDistrito(String idDepartamento, 
			String idProvincia,
			String idDistrito) {
		
		Long _totalVotantesDepartamento = mesaDeVotacionService.getSumVotantesDepartamento(idDepartamento);
		Long _totalVotantesProvincia = mesaDeVotacionService.getSumVotantesProvincia(idDepartamento, idProvincia);
		Long _totalVotantesDistrito = mesaDeVotacionService.getSumVotantesDistrito(idDepartamento, idProvincia, idDistrito);
		
		Long _cntMesasDepartamento = mesaDeVotacionService.getCountVotantesDepartamento(idDepartamento);
		Long _cntMesasProvincia = mesaDeVotacionService.getCountVotantesProvincia(idDepartamento, idProvincia);
		Long _cntMesasDistrito = mesaDeVotacionService.getCountVotantesDistrito(idDepartamento, idProvincia,idDistrito);
		
		List<ResultadoResumenPojo> lst = voto002Service.getResultadoResumenDepartamentoProvinciaDistrito(idDepartamento,idProvincia,idDistrito);
		for(ResultadoResumenPojo row: lst) {
			row.set_totalVotantesDepartamento(_totalVotantesDepartamento);
			row.set_totalVotantesProvincia(_totalVotantesProvincia);
			row.set_totalVotantesDistrito(_totalVotantesDistrito);
			
			row.set_cntMesasDepartamento(_cntMesasDepartamento);
			row.set_cntMesasProvincia(_cntMesasProvincia);			
			row.set_cntMesasDistrito(_cntMesasDistrito);
		}
		
		return lst;		
		
	}
	
	@RequestMapping("/getResultadoResumenDepartamentoProvinciaDistritoCentroDeVotacion")
	@ResponseBody					
	public List<ResultadoResumenPojo> getResultadoResumenDepartamentoProvinciaDistritoCentroDeVotacion(
			String idDepartamento, 
			String idProvincia,
			String idDistrito,
			String idCentroDeVotacion
			){
		
		Long _totalVotantesDepartamento = mesaDeVotacionService.getSumVotantesDepartamento(idDepartamento);
		Long _totalVotantesProvincia = mesaDeVotacionService.getSumVotantesProvincia(idDepartamento, idProvincia);
		Long _totalVotantesDistrito = mesaDeVotacionService.getSumVotantesDistrito(idDepartamento, idProvincia, idDistrito);
		Long _totalVotantesCentroDeVotacion = mesaDeVotacionService.getSumVotantesCentroDeVotacion(idDepartamento, idProvincia, idDistrito,idCentroDeVotacion);
		
		Long _cntMesasDepartamento = mesaDeVotacionService.getCountVotantesDepartamento(idDepartamento);
		Long _cntMesasProvincia = mesaDeVotacionService.getCountVotantesProvincia(idDepartamento, idProvincia);
		Long _cntMesasDistrito = mesaDeVotacionService.getCountVotantesDistrito(idDepartamento, idProvincia,idDistrito);		
		Long _cntMesasCentroDeVotacion = mesaDeVotacionService.getCountVotantesCentroDeVotacion(idDepartamento, idProvincia, idDistrito, idCentroDeVotacion);
		
		List<ResultadoResumenPojo> lst = voto002Service.getResultadoResumenDepartamentoProvinciaDistritoCentroDeVotacion(idDepartamento, idProvincia, idDistrito, idCentroDeVotacion) ;
		
		for(ResultadoResumenPojo row: lst) {
			row.set_totalVotantesDepartamento(_totalVotantesDepartamento);
			row.set_totalVotantesProvincia(_totalVotantesProvincia);
			row.set_totalVotantesDistrito(_totalVotantesDistrito);
			row.set_totalVotantesCentroDeVotacion(_totalVotantesCentroDeVotacion);
			
			row.set_cntMesasDepartamento(_cntMesasDepartamento);
			row.set_cntMesasProvincia(_cntMesasProvincia);			
			row.set_cntMesasDistrito(_cntMesasDistrito);			
			row.set_cntMesasCentroDeVotacion(_cntMesasCentroDeVotacion);
		}
		
		return lst;				
		
	}
	



}
