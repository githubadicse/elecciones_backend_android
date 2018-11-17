package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.MesaDeVotacion;

public interface IMesaDeVotacionDao extends CrudRepository<MesaDeVotacion, Integer> {
	
	
	@Query("select p from MesaDeVotacion p where p.personero.idpersonero = :idPersonero and p.flagRegistrado =:flagRegistrado")
	List<MesaDeVotacion> getMesasDeVotacionByIdPersonero(@Param("idPersonero") String idPersonero, @Param("flagRegistrado") Boolean flagRegistrado);

}
