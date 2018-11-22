package com.adicse.eleccion.repo;

import org.springframework.data.repository.CrudRepository;

import com.adicse.eleccion.model.Departamento;

public interface IDepartamentoDao extends CrudRepository<Departamento, String> {

}
