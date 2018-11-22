package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.Distrito;

public interface IDistritoDao extends CrudRepository<Distrito, String> {
	
	@Query("select p from Distrito p where p.provincia.idprovincia =:idProvincia")
	List<Distrito> getDistritoByIdProvincia(@Param("idProvincia") String idProvincia);	

}
