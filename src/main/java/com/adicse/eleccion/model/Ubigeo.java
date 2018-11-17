package com.adicse.eleccion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
@NamedQuery(name="Ubigeo.findAll", query="SELECT u FROM Ubigeo u")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idubigeo;

	private String departamento;

	private String distrito;

	private String dscubigeo;

	private String provincia;

	private Integer totalelectores;

	//bi-directional many-to-one association to MesaDeVotacion
	@OneToMany(mappedBy="ubigeo")
	private List<MesaDeVotacion> mesaDeVotacions;

	public Ubigeo() {
	}

	public Integer getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(Integer idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDscubigeo() {
		return this.dscubigeo;
	}

	public void setDscubigeo(String dscubigeo) {
		this.dscubigeo = dscubigeo;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getTotalelectores() {
		return this.totalelectores;
	}

	public void setTotalelectores(Integer totalelectores) {
		this.totalelectores = totalelectores;
	}

	public List<MesaDeVotacion> getMesaDeVotacions() {
		return this.mesaDeVotacions;
	}

	public void setMesaDeVotacions(List<MesaDeVotacion> mesaDeVotacions) {
		this.mesaDeVotacions = mesaDeVotacions;
	}

	public MesaDeVotacion addMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		getMesaDeVotacions().add(mesaDeVotacion);
		mesaDeVotacion.setUbigeo(this);

		return mesaDeVotacion;
	}

	public MesaDeVotacion removeMesaDeVotacion(MesaDeVotacion mesaDeVotacion) {
		getMesaDeVotacions().remove(mesaDeVotacion);
		mesaDeVotacion.setUbigeo(null);

		return mesaDeVotacion;
	}

}