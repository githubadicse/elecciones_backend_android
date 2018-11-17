package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddistrito;

	private String dscdistrito;

	public Distrito() {
	}

	public Integer getIddistrito() {
		return this.iddistrito;
	}

	public void setIddistrito(Integer iddistrito) {
		this.iddistrito = iddistrito;
	}

	public String getDscdistrito() {
		return this.dscdistrito;
	}

	public void setDscdistrito(String dscdistrito) {
		this.dscdistrito = dscdistrito;
	}

}