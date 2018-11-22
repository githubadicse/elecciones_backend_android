package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Departamento;
import com.adicse.eleccion.repo.IDepartamentoDao;

@Service
@Transactional
public class DepartamentoService implements IAdicseService<Departamento, String> {
	
	@Autowired
	IDepartamentoDao iDepartamentoDao;

	@Override
	public Page<Departamento> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> getall() {
		// TODO Auto-generated method stub
		return (List<Departamento>) iDepartamentoDao.findAll() ;
	}

	@Override
	public List<Departamento> getallbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento create(Departamento entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento update(Departamento entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Departamento entidad) {
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
	public Optional<Departamento> findbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
