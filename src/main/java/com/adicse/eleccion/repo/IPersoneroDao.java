package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adicse.eleccion.model.Personero;

public interface IPersoneroDao extends CrudRepository<Personero, String> {
	
	@Query("select p from Personero p where p.usuario.idusuario = :idUsuario")
	List<Personero> getPersonerosByIdUsuario(@Param("idUsuario") Integer idUsuario);	

}
