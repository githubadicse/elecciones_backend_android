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
	
	
	@Query("select sum(p.numeroDeVotantes) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento")
	Long getSumVotantesDepartamento(@Param("idDepartamento") String idDepartamento);
	
	@Query("select sum(p.numeroDeVotantes) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia")
	Long getSumVotantesProvincia(@Param("idDepartamento") String idDepartamento, @Param("idProvincia") String idProvincia);	
	
	@Query("select sum(p.numeroDeVotantes) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia and p.centroDeVotacion.distrito.iddistrito =:idDistrito ")
	Long getSumVotantesDistrito(@Param("idDepartamento") String idDepartamento, @Param("idProvincia") String idProvincia, @Param("idDistrito") String idDistrito);
	
	@Query("select sum(p.numeroDeVotantes) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia and p.centroDeVotacion.distrito.iddistrito =:idDistrito "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia and p.centroDeVotacion.idCentroDeVotacion =:idCentroDeVotacion")
	Long getSumVotantesCentroDeVotacion(@Param("idDepartamento") String idDepartamento, @Param("idProvincia") String idProvincia, 
			@Param("idDistrito") String idDistrito, @Param("idCentroDeVotacion") String idCentroDeVotacion);			

	
	
	
	@Query("select count(p) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento")
	Long getCountVotantesDepartamento(@Param("idDepartamento") String idDepartamento);
	
	@Query("select count(p) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia")
	Long getCountVotantesProvincia(@Param("idDepartamento") String idDepartamento, @Param("idProvincia") String idProvincia);	
	
	@Query("select count(p) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia and p.centroDeVotacion.distrito.iddistrito =:idDistrito ")
	Long getCountVotantesDistrito(@Param("idDepartamento") String idDepartamento, @Param("idProvincia") String idProvincia, @Param("idDistrito") String idDistrito);
	
	@Query("select count(p) from MesaDeVotacion p where p.centroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia and p.centroDeVotacion.distrito.iddistrito =:idDistrito "
			+ " and p.centroDeVotacion.distrito.provincia.idprovincia =:idProvincia and p.centroDeVotacion.idCentroDeVotacion =:idCentroDeVotacion")
	Long getCountVotantesCentroDeVotacion(@Param("idDepartamento") String idDepartamento, @Param("idProvincia") String idProvincia, 
			@Param("idDistrito") String idDistrito, @Param("idCentroDeVotacion") String idCentroDeVotacion);	
}
