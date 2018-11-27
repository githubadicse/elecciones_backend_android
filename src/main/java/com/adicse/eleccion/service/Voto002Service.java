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
import com.adicse.eleccion.model.Voto002;
import com.adicse.eleccion.pojo.ResultadoPojo;
import com.adicse.eleccion.pojo.ResultadoResumenPojo;
import com.adicse.eleccion.repo.IVoto002Dao;
import com.adicse.eleccion.specification.ConvertObjectToFormatJson;
import com.adicse.eleccion.specification.Filter;




@Service
@Transactional
public class Voto002Service implements IAdicseService<Voto002, String> {
	
	@Autowired
	private IVoto002Dao iVoto002Dao;
	
	@Autowired
	private ConvertObjectToFormatJson convertObjectToFormatJson; 
	

	
	
	@Override
	public Page<Voto002> pagination(Integer pagenumber, Integer rows, String sortdireccion, String sortcolumn,
			Object filter) {
		
		Sort sort = new Sort(sortdireccion.toUpperCase() == "DESC" ? Direction.DESC : Direction.ASC, sortcolumn);
		Pageable pageable =  PageRequest.of(pagenumber, rows, sort);
		
		Filter f = convertObjectToFormatJson.ConvertObjectToFormatSpecification(filter);

		Page<Voto002> lista = selectFrom(iVoto002Dao).where(f).findPage(pageable);
	
 

		return lista;
	}

	@Override
	public List<Voto002> getall() {
		// TODO Auto-generated method stub
		return (List<Voto002>) iVoto002Dao.findAll();
	}

	@Override
	public List<Voto002> getallbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voto002 create(Voto002 voto002) {
		// TODO Auto-generated method stub

		return iVoto002Dao.save(voto002);
	}

	@Override
	public Voto002 update(Voto002 voto002) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Voto002 voto002) {
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
	public Optional<Voto002> findbyid(String id) {
		// TODO Auto-generated method stub
		return iVoto002Dao.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ResultadoPojo> getResultado(){
		return iVoto002Dao.getResultado();
	}
	
	public List<ResultadoResumenPojo> getResultadoResumenDepartamento(String idDepartamento){
		return iVoto002Dao.getResultadoResumenDepartamento(idDepartamento);
	}
	
	public List<ResultadoResumenPojo> getResultadoResumenDepartamentoProvincia(String idDepartamento, String idProvincia){
		return iVoto002Dao.getResultadoResumenDepartamentoProvincia(idDepartamento, idProvincia);
		
	}
	
	public List<ResultadoResumenPojo> getResultadoResumenDepartamentoProvinciaDistrito(String idDepartamento, 
			String idProvincia,
			String idDistrito){
		
		return iVoto002Dao.getResultadoResumenDepartamentoProvinciaDistrito(idDepartamento, idProvincia, idDistrito);
		
	}
	
	public List<ResultadoResumenPojo> getResultadoResumenDepartamentoProvinciaDistritoCentroDeVotacion(
			String idDepartamento, 
			String idProvincia,
			String idDistrito,
			String idCentroDeVotacion
			){
		return iVoto002Dao.getResultadoResumenDepartamentoProvinciaDistritoCentroDeVotacion(idDepartamento, idProvincia, idDistrito, idCentroDeVotacion);
	}
	
	
	public void DeleteByIdVoto001(Integer idVoto001) {
		iVoto002Dao.DeleteByIdVoto001(idVoto001);
	}


}
