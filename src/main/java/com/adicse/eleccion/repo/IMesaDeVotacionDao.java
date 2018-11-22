package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.MesaDeVotacion;

public interface IMesaDeVotacionDao extends CrudRepository<MesaDeVotacion, Integer>,
JpaRepository<MesaDeVotacion,Integer>, 
PagingAndSortingRepository<MesaDeVotacion, Integer>, 
JpaSpecificationExecutor<MesaDeVotacion> 
{
	
	
	@Query("select p from MesaDeVotacion p where p.personero.idpersonero = :idPersonero and p.flagRegistrado =:flagRegistrado")
	List<MesaDeVotacion> getMesasDeVotacionByIdPersonero(@Param("idPersonero") String idPersonero, @Param("flagRegistrado") Boolean flagRegistrado);
	
	@Query("select p from MesaDeVotacion p where p.centroDeVotacion.idCentroDeVotacion =:idCentroDeVotacion")
	List<MesaDeVotacion> getMesaDeVotacionByIdCentroDeVotacion(@Param("idCentroDeVotacion") String idCentroDeVotacion);
	

}
