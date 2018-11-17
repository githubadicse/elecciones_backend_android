package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddepartamento;

	private String dscdepartamento;

	public Departamento() {
	}

	public Integer getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getDscdepartamento() {
		return this.dscdepartamento;
	}

	public void setDscdepartamento(String dscdepartamento) {
		this.dscdepartamento = dscdepartamento;
	}

}