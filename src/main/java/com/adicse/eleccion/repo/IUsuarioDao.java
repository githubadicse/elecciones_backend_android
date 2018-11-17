package com.adicse.eleccion.repo;

import org.springframework.data.repository.CrudRepository;

import com.adicse.eleccion.model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario , Integer> {
	
	public Usuario findAllByLogin(String login);

}
