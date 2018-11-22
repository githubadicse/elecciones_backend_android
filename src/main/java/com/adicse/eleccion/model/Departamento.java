package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iddepartamento;

	private String dscdepartamento;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="departamento")
	private List<Provincia> provincias;

	public Departamento() {
	}

	public String getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(String iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getDscdepartamento() {
		return this.dscdepartamento;
	}

	public void setDscdepartamento(String dscdepartamento) {
		this.dscdepartamento = dscdepartamento;
	}

	public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Provincia addProvincia(Provincia provincia) {
		getProvincias().add(provincia);
		provincia.setDepartamento(this);

		return provincia;
	}

	public Provincia removeProvincia(Provincia provincia) {
		getProvincias().remove(provincia);
		provincia.setDepartamento(null);

		return provincia;
	}

}