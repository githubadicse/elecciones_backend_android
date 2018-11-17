package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.MesaDeVotacion;
import com.adicse.eleccion.repo.IMesaDeVotacionDao;

@Service
@Transactional
public class MesaDeVotacionService implements IAdicseService<MesaDeVotacion, Integer> {

	
	@Autowired
	private IMesaDeVotacionDao iMesaDeVotacionDao;
	
	@Override
	public Page<MesaDeVotacion> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MesaDeVotacion> getall() {
		// TODO Auto-generated method stub
		return null;
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

}
