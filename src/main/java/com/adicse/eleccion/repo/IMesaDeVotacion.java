package com.adicse.eleccion.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adicse.eleccion.model.MesaDeVotacion;

public interface IMesaDeVotacion extends CrudRepository<MesaDeVotacion, String> {
	
	
	//List<MesaDeVotacion> getMesasDeVotacionByIdPersonero(@Param)

}
