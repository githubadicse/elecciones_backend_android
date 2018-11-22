package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Distrito;
import com.adicse.eleccion.repo.IDistritoDao;

@Service
@Transactional
public class DistritoService implements IAdicseService<Distrito, String> {
	
	@Autowired
	IDistritoDao  iDistritoDao;

	@Override
	public Page<Distrito> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Distrito> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Distrito> getallbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distrito create(Distrito entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distrito update(Distrito entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Distrito entidad) {
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
	public Optional<Distrito> findbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Distrito> getDistritoByIdProvincia(String idProvincia){
		return iDistritoDao.getDistritoByIdProvincia(idProvincia);
	}

}
