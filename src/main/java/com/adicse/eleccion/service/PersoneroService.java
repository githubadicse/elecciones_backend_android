package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Personero;
import com.adicse.eleccion.repo.IPersoneroDao;

@Service
@Transactional
public class PersoneroService implements IAdicseService<Personero, String> {
	
	@Autowired
	private IPersoneroDao iPersoneroDao;	

	@Override
	public Page<Personero> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personero> getall() {
		// TODO Auto-generated method stub
		return (List<Personero>) iPersoneroDao.findAll();
	}

	@Override
	public List<Personero> getallbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personero create(Personero entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personero update(Personero entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personero entidad) {
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
	public Optional<Personero> findbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	public List<Personero> getPersonerosByIdUsuario(Integer idUsuario){
		return iPersoneroDao.getPersonerosByIdUsuario(idUsuario);
	}	
	


}
