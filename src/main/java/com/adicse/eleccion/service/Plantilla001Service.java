package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Plantilla001;
import com.adicse.eleccion.repo.IPlantilla001Dao;

@Service
@Transactional
public class Plantilla001Service implements IAdicseService<Plantilla001, Integer> {
	
	
	@Autowired
	IPlantilla001Dao  iPlantilla001Dao;

	@Override
	public Page<Plantilla001> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plantilla001> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plantilla001> getallbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla001 create(Plantilla001 entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla001 update(Plantilla001 entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Plantilla001 entidad) {
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
	public Optional<Plantilla001> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return iPlantilla001Dao.findById(id) ;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
