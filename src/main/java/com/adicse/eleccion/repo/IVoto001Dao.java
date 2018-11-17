package com.adicse.eleccion.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.Voto001;

public interface IVoto001Dao extends CrudRepository<Voto001, Integer> {
	
	@Query("SELECT max(p.idvoto001) FROM Voto001 p")
	Integer getMax();		
	
	
	@Query("select p from Voto001 p where p.mesaDeVotacion.idMesaDeVotacion = :idMesaDeVotacion")
	Voto001 getVotoByNumeroMesa(@Param("idMesaDeVotacion") Integer idMesaDeVotacion );	

}
