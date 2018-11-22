package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Provincia;
import com.adicse.eleccion.repo.IProvinciaDao;

@Service
@Transactional
public class ProvinciaService implements IAdicseService<Provincia, String> {
	
	@Autowired
	IProvinciaDao  iProvinciaDao;

	@Override
	public Page<Provincia> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provincia> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provincia> getallbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia create(Provincia entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia update(Provincia entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Provincia entidad) {
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
	public Optional<Provincia> findbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Provincia> getProvinciaByIdDepartamento(String idDepartamento){
		
		return iProvinciaDao.getProvinciaByIdDepartamento(idDepartamento);
		
	}

}
