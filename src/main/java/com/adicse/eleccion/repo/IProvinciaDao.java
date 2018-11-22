package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.Provincia;

public interface IProvinciaDao extends CrudRepository<Provincia, String> {
	
	@Query("select p from Provincia p where p.departamento.iddepartamento =:idDepartamento")
	List<Provincia> getProvinciaByIdDepartamento(@Param("idDepartamento") String idDepartamento);

}
