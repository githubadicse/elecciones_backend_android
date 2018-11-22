package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.CentroDeVotacion;

public interface ICentroDeVotacionDao extends CrudRepository<CentroDeVotacion, String> {
	
	
	@Query("select p from CentroDeVotacion p where p.distrito.iddistrito = :idDistrito")
	List<CentroDeVotacion> getCentroDeVotacionByDistrito(@Param("idDistrito") String idDistrito);

}
