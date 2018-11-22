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

import com.adicse.eleccion.repo.INivelDao;
import com.adicse.eleccion.model.Nivel;
import com.adicse.eleccion.specification.ConvertObjectToFormatJson;
import com.adicse.eleccion.specification.Filter;




@Service
@Transactional
public class NivelService implements IAdicseService<Nivel, Integer> {
	
	@Autowired
	private INivelDao iNivelDao;
	
	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson; 
	

	
	
	@Override
	public Page<Nivel> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
		
		Filter f = convertObjectToFormatJson.ConvertObjectToFormatSpecification(filter);

		Page<Nivel> lista = selectFrom(iNivelDao).where(f).findPage(pageable);
	
 

		return lista;
	}

	@Override
	public List<Nivel> getall() {
		// TODO Auto-generated method stub
		return (List<Nivel>) iNivelDao.findAll();
	}

	@Override
	public List<Nivel> getallbyid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nivel create(Nivel nivel) {
		// TODO Auto-generated method stub
		if(nivel.getIdnivel() == 0) {
			Integer id = iNivelDao.getMax()==null?1:iNivelDao.getMax()+1;
			nivel.setIdnivel(id);
		}
		return iNivelDao.save(nivel);
	}

	@Override
	public Nivel update(Nivel nivel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Nivel nivel) {
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
	public Optional<Nivel> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return iNivelDao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}


}
