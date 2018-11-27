package com.adicse.eleccion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adicse.eleccion.interfaces.IAdicseService;
import com.adicse.eleccion.model.Voto001;
import com.adicse.eleccion.model.Voto002;
import com.adicse.eleccion.repo.IVoto001Dao;


@Service
@Transactional
public class Voto001Service implements IAdicseService<Voto001, Integer> {
	
	@Autowired
	private IVoto001Dao iVoto001Dao;

	@Override
	public Page<Voto001> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto001> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto001> getallbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voto001 create(Voto001 entidad) {
		// TODO Auto-generated method stub
		if(entidad.getIdvoto001().equals(0)) {
			Integer id = iVoto001Dao.getMax() == null?1:iVoto001Dao.getMax() + 1;
			entidad.setIdvoto001(id);
		}		

		for (Voto002 row : entidad.getVoto002s()) {
			row.setVoto001(entidad);
		}
		return  iVoto001Dao.save(entidad);		
		

	}

	@Override
	public Voto001 update(Voto001 entidad) {
		// TODO Auto-generated method stub
		
		Voto001 voto001Update = iVoto001Dao.findById(1).get();

		BeanUtils.copyProperties(entidad, voto001Update);
		for (Voto002 row : voto001Update.getVoto002s()) {
			row.setVoto001(entidad);
		}

		return iVoto001Dao.save(voto001Update);

	}

	@Override
	public void delete(Voto001 entidad) {
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
	public Optional<Voto001> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return iVoto001Dao.findById(id);
	}
	
	

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Voto001 getVotoByNumeroMesa(Integer idMesaDeVotacion ) {
		
		return iVoto001Dao.getVotoByNumeroMesa(idMesaDeVotacion);
		
	}
	
	public Voto001 getVoto001ByIdVoto001(Integer idVoto001) {
		return iVoto001Dao.getVoto001ByIdVoto001(idVoto001);
	}

}
