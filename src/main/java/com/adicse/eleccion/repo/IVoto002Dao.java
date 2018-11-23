package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.Voto002;
import com.adicse.eleccion.pojo.ResultadoPojo;
import com.adicse.eleccion.pojo.ResultadoResumenPojo;

public interface IVoto002Dao extends CrudRepository<Voto002, String>,JpaRepository<Voto002,String>, 
PagingAndSortingRepository<Voto002, String>, 
JpaSpecificationExecutor<Voto002> {
	

	@Query("select "
			+ " new com.adicse.eleccion.pojo.ResultadoPojo( "
			
			+ "p.plantilla002.orden , "
			+ "p.voto001.idvoto001,"
			+ "p.plantilla002.candidato.agrupacion.dscagrupacion ,"
			+ "p.plantilla002.candidato.nombre, "
			+ "p.voto001.mesaDeVotacion.numeroDeMesa,"
			+ "p.voto001.mesaDeVotacion.numeroDeVotantes,"
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion,"
			
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.iddistrito,"
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.dscdistrito,"
			
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.idprovincia,"
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.dscprovincia,"
			
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.departamento.iddepartamento,"
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.departamento.dscdepartamento,"
			+ "p.voto  "

			
			+ ")  from Voto002 p  ")
			
	List<ResultadoPojo> getResultado();
	
	@Query("select "
			+ " new com.adicse.eleccion.pojo.ResultadoResumenPojo( "
			+ " p.plantilla002.orden,"
			
			+ "p.plantilla002.candidato.agrupacion.dscagrupacion,"
			+ "count(p.voto001.mesaDeVotacion.numeroDeMesa) as cntNumeroDeMesa, "
			
			+ "sum(p.voto001.mesaDeVotacion.numeroDeVotantes) as numeroDeVotantes,"
			
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.departamento.dscdepartamento,"
			+ "sum(p.voto) as voto, "
			+ "sum(0) as _totalVotantesDepartamento,"			
			+ "sum(0) as _totalVotantesProvincia,"
			+ "sum(0) as _totalVotantesDistrito,"
			+ "sum(0) as _totalVotantesCentroDeVotacion,"
			
			+ "sum(0) as _cntMesasDepartamento,"
			+ "sum(0) as _cntMesasProvincia,"
			+ "sum(0) as _cntMesasDistrito,"
			+ "sum(0) as _cntMesasCentroDeVotacion"			
			
			+ ")  from Voto002 p  "
			+ "where p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.departamento.iddepartamento =:idDepartamento "

			+ "GROUP BY "
			+ " p.plantilla002.orden,"

			+ "p.plantilla002.candidato.agrupacion.dscagrupacion,"
			+ "p.voto001.mesaDeVotacion.centroDeVotacion.nombreCentroDeVotacion.distrito.provincia.departamento.dscdepartamento "
			+ "ORDER BY p.plantilla002.orden")
			
	List<ResultadoResumenPojo> getResultadoResumenDepartamento(@Param("idDepartamento") String idDepartamento);	

}