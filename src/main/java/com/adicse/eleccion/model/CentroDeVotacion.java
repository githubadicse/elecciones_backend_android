package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the centro_de_votacion database table.
 * 
 */
@Entity
@Table(name="centro_de_votacion")
@NamedQuery(name="CentroDeVotacion.findAll", query="SELECT c FROM CentroDeVotacion c")
public class CentroDeVotacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_centro_de_votacion")
	private String idCentroDeVotacion;

	@Column(name="nombre_centro_de_votacion")
	private String nombreCentroDeVotacion;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="iddistrito")
	private Distrito distrito;

	//bi-directional many-to-one association to MesaDeVotacion
	@OneToMany(mappedBy="centroDeVotacion")
	private List<MesaDeVotacion> mesaDeVotacions;

	public CentroDeVotacion() {
	}

	public String getIdCentroDeVotacion() {
		return this.idCentroDeVotacion;
	}

	public void setIdCentroDeVotacion(String idCentroDeVotacion) {
		this.idCentroDeVotacion = idCentroDeVotacion;
	}

	public String getNombreCentroDeVotacion() {
		return this.nombreCentroDeVotacion;
	}

	public void setNombreCentroDeVotacion(String nombreCentroDeVotacion) {
		this.nombreCentroDeVotacion = nombreCentroDeVotacion;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<MesaDeVotacion> getMesaDeVotacions() {
		return this.mesaDeVotacions;
	}

	public void setMesaDeVotacions(List<MesaDeVotacion> mesaDeVotacions) {
		this.mesaDeVotacions = mesaDeVotacions;
	}

	public MesaDeVotacion addMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		getMesaDeVotacions().add(mesaDeVotacion);
		mesaDeVotacion.setCentroDeVotacion(this);

		return mesaDeVotacion;
	}

	public MesaDeVotacion removeMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		getMesaDeVotacions().remove(mesaDeVotacion);
		mesaDeVotacion.setCentroDeVotacion(null);

		return mesaDeVotacion;
	}

}