package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iddistrito;

	private String dscdistrito;

	//bi-directional many-to-one association to CentroDeVotacion
	@OneToMany(mappedBy="distrito")
	private List<CentroDeVotacion> centroDeVotacions;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="idprovincia")
	private Provincia provincia;

	public Distrito() {
	}

	public String getIddistrito() {
		return this.iddistrito;
	}

	public void setIddistrito(String iddistrito) {
		this.iddistrito = iddistrito;
	}

	public String getDscdistrito() {
		return this.dscdistrito;
	}

	public void setDscdistrito(String dscdistrito) {
		this.dscdistrito = dscdistrito;
	}

	public List<CentroDeVotacion> getCentroDeVotacions() {
		return this.centroDeVotacions;
	}

	public void setCentroDeVotacions(List<CentroDeVotacion> centroDeVotacions) {
		this.centroDeVotacions = centroDeVotacions;
	}

	public CentroDeVotacion addCentroDeVotacion(CentroDeVotacion centroDeVotacion) {
		getCentroDeVotacions().add(centroDeVotacion);
		centroDeVotacion.setDistrito(this);

		return centroDeVotacion;
	}

	public CentroDeVotacion removeCentroDeVotacion(CentroDeVotacion centroDeVotacion) {
		getCentroDeVotacions().remove(centroDeVotacion);
		centroDeVotacion.setDistrito(null);

		return centroDeVotacion;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}