package com.adicse.eleccion.service;

import static com.adicse.eleccion.specification.SpecificationBuilder.selectFrom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.MesaDeVotacion;
import com.adicse.eleccion.repo.IMesaDeVotacionDao;
import com.adicse.eleccion.specification.ConvertObjectToFormatJson;
import com.adicse.eleccion.specification.Filter;

@Service
@Transactional
public class MesaDeVotacionService implements IAdicseService<MesaDeVotacion, Integer> {

	
	@Autowired
	private IMesaDeVotacionDao iMesaDeVotacionDao;
	
	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson; 	
	
	@Override
	public Page<MesaDeVotacion> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
		
		Filter f = convertObjectToFormatJson.ConvertObjectToFormatSpecification(filter);

		Page<MesaDeVotacion> lista = selectFrom(iMesaDeVotacionDao).where(f).findPage(pageable);
	
 

		return lista;
	}

	@Override
	public List<MesaDeVotacion> getall() {
		// TODO Auto-generated method stub
		return (List<MesaDeVotacion>) iMesaDeVotacionDao.findAll();		
	}

	@Override
	public List<MesaDeVotacion> getallbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MesaDeVotacion create(MesaDeVotacion entidad) {
		// TODO Auto-generated method stub

		return iMesaDeVotacionDao.save(entidad);
	}

	@Override
	public MesaDeVotacion update(MesaDeVotacion entidad) {
		// TODO Auto-generated method stub
		return iMesaDeVotacionDao.save(entidad);
	}

	@Override
	public void delete(MesaDeVotacion entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyid(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MesaDeVotacion> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return iMesaDeVotacionDao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MesaDeVotacion> getMesasDeVotacionByIdPersonero(String idPersonero, Boolean flagRegistrado){
		return iMesaDeVotacionDao.getMesasDeVotacionByIdPersonero(idPersonero, flagRegistrado);
	}

	public List<MesaDeVotacion> getMesaDeVotacionByIdCentroDeVotacion(String idCentroDeVotacion){
		return iMesaDeVotacionDao.getMesaDeVotacionByIdCentroDeVotacion(idCentroDeVotacion);
	}
	
	public Long getSumVotantesDepartamento(String idDepartamento) {
		return iMesaDeVotacionDao.getSumVotantesDepartamento(idDepartamento);
	}
	
	public Long getSumVotantesProvincia(String idDepartamento, String idProvincia) {
		return iMesaDeVotacionDao.getSumVotantesProvincia(idDepartamento, idProvincia);
	}
	
	public Long getSumVotantesDistrito(String idDepartamento, String idProvincia, String idDistrito) {
		return iMesaDeVotacionDao.getSumVotantesDistrito(idDepartamento, idProvincia, idDistrito);
	}
	
	public Long getSumVotantesCentroDeVotacion(String idDepartamento, String idProvincia, 
			String idDistrito, String idCentroDeVotacion) {
		return iMesaDeVotacionDao.getSumVotantesCentroDeVotacion(idDepartamento, idProvincia, idDistrito, idCentroDeVotacion);
	}
	
	
	
	public Long getCountVotantesDepartamento(String idDepartamento) {
		return iMesaDeVotacionDao.getCountVotantesDepartamento(idDepartamento);
	}
	
	public Long getCountVotantesProvincia(String idDepartamento, String idProvincia) {
		return iMesaDeVotacionDao.getCountVotantesProvincia(idDepartamento, idProvincia);
	}
	
	public Long getCountVotantesDistrito(String idDepartamento, String idProvincia, String idDistrito) {
		return iMesaDeVotacionDao.getCountVotantesDistrito(idDepartamento, idProvincia, idDistrito);
	}
	
	public Long getCountVotantesCentroDeVotacion(String idDepartamento, String idProvincia, 
			String idDistrito, String idCentroDeVotacion) {
		return iMesaDeVotacionDao.getCountVotantesCentroDeVotacion(idDepartamento, idProvincia, idDistrito, idCentroDeVotacion);
	}	
	
}
