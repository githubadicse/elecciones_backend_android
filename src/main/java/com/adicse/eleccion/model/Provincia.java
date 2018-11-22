package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idprovincia;

	private String dscprovincia;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="provincia")
	private List<Distrito> distritos;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="iddepartamento")
	private Departamento departamento;

	public Provincia() {
	}

	public String getIdprovincia() {
		return this.idprovincia;
	}

	public void setIdprovincia(String idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getDscprovincia() {
		return this.dscprovincia;
	}

	public void setDscprovincia(String dscprovincia) {
		this.dscprovincia = dscprovincia;
	}

	public List<Distrito> getDistritos() {
		return this.distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Distrito addDistrito(Distrito distrito) {
		getDistritos().add(distrito);
		distrito.setProvincia(this);

		return distrito;
	}

	public Distrito removeDistrito(Distrito distrito) {
		getDistritos().remove(distrito);
		distrito.setProvincia(null);

		return distrito;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}