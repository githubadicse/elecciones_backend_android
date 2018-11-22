package com.adicse.eleccion.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.adicse.eleccion.model.Nivel;

public interface INivelDao extends CrudRepository<Nivel, Integer>,
JpaRepository<Nivel,Integer>, 
PagingAndSortingRepository<Nivel, Integer>, 
JpaSpecificationExecutor<Nivel> {
	
	@Query("SELECT max(p.idnivel) FROM Nivel p")
	Integer getMax();

}
