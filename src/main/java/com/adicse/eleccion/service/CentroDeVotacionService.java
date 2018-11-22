package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.CentroDeVotacion;
import com.adicse.eleccion.repo.ICentroDeVotacionDao;

@Service
@Transactional
public class CentroDeVotacionService implements IAdicseService<CentroDeVotacion, String> {
	
	@Autowired
	ICentroDeVotacionDao   iCentroDeVotacionDao;

	@Override
	public Page<CentroDeVotacion> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CentroDeVotacion> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CentroDeVotacion> getallbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroDeVotacion create(CentroDeVotacion entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroDeVotacion update(CentroDeVotacion entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CentroDeVotacion entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletebyid(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean exists(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CentroDeVotacion> findbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<CentroDeVotacion> getCentroDeVotacionByDistrito(@Param("idDistrito") String idDistrito){
		
		return iCentroDeVotacionDao.getCentroDeVotacionByDistrito(idDistrito);
		
		
	}
	


}
