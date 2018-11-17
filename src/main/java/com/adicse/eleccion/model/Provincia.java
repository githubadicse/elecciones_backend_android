package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idprovincia;

	private String dscprovincia;

	public Provincia() {
	}

	public Integer getIdprovincia() {
		return this.idprovincia;
	}

	public void setIdprovincia(Integer idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getDscprovincia() {
		return this.dscprovincia;
	}

	public void setDscprovincia(String dscprovincia) {
		this.dscprovincia = dscprovincia;
	}

}